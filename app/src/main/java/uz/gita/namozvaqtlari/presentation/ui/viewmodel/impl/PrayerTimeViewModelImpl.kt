package uz.gita.namozvaqtlari.presentation.ui.viewmodel.impl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.futboollegueapplication.data.model.tableview.*
import uz.gita.namozvaqtlari.data.local.entity.PrayerTimeEntity
import uz.gita.namozvaqtlari.data.local.entity.Query
import uz.gita.namozvaqtlari.data.tableview.RowHeader
import uz.gita.namozvaqtlari.data.tableview.TableDataWrapper
import uz.gita.namozvaqtlari.domain.usecase.PrayerTimeUseCase
import uz.gita.namozvaqtlari.presentation.ui.viewmodel.PrayerTimeViewModel
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class PrayerTimeViewModelImpl @Inject constructor(val useCase: PrayerTimeUseCase) :
    PrayerTimeViewModel, ViewModel() {
    override val leagueListLiveData = MutableLiveData<TableDataWrapper>()
    override val monthlyPrayerTimeList = MutableStateFlow<List<PrayerTimeEntity>>(emptyList())

    override fun getPrayerTime(query: Query) {

        var k = 0
        viewModelScope.launch {
            useCase.getMonthlyPayerTime(query).collectLatest { it ->
                useCase.sync(query)
                monthlyPrayerTimeList.value = it


                Log.d("XXX", "Salom")
                val columnHeader =
                    listOf(
                        "Kun nomi",
                        "Tong",
                        "Quyosh",
                        "Peshin",
                        "Asr",
                        "Shom",
                        "Xufton"
                    ).map { ColumnHeader(it) }


                val rowHeader = (1..it.size).map {
                    RowHeader(it.toString())
                }
                val cellList = it.map {
                    listOf(
                        TextCell(it.weekday),
                        TextCell(it.times.earlyMorning),
                        TextCell(it.times.sun),
                        TextCell(it.times.noon),
                        TextCell(it.times.century),
                        TextCell(it.times.evening),
                        TextCell(it.times.night),
                    )

                }

                leagueListLiveData.value = TableDataWrapper(rowHeader, columnHeader, cellList)
                Log.d("TTT", it.toString())
                k++
                if (k >= 1) {
                    k = 0
                    cancel()
                }
            }
        }
    }

//    private fun getCellListForSortingTest(): List<List<Cell>> {
//        val list: MutableList<List<Cell>> = ArrayList<List<Cell>>()
//        for (i in 0 until 8) {
//            val cellList: MutableList<Cell> = ArrayList<Cell>()
//            for (j in 0 until 31) {
//                var text: Any? = "cell $j $i"
//
//                val id = "$j-$i"
//                var cell: Cell
//
//                    cell = Cell(id, text)
//
//                cellList.add(cell)
//            }
//            list.add(cellList)
//        }
//        return list
//    }
//
//    private fun getSimpleRowHeaderList(): List<RowHeader> {
//        val list: MutableList<RowHeader> = ArrayList<RowHeader>()
//        for (i in 1 until 31) {
//            val header = RowHeader(i.toString(), "$i")
//            list.add(header)
//        }
//        return list
//    }
//
//    private fun getRandomColumnHeaderList(): List<ColumnHeader>? {
//        val list: MutableList<ColumnHeader> = ArrayList()
//        for (i in 1 until 8) {
//            val title = "column $i"
//            val header = ColumnHeader(i.toString(), title)
//            list.add(header)
//        }
//        return list
//    }
}