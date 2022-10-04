package uz.gita.namozvaqtlari.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import uz.gita.namozvaqtlari.data.local.entity.PrayerTimeEntity
import uz.gita.namozvaqtlari.data.local.entity.Query
import uz.gita.namozvaqtlari.data.tableview.TableDataWrapper

interface PrayerTimeViewModel {

    val monthlyPrayerTimeList: Flow<List<PrayerTimeEntity>>
    val leagueListLiveData: LiveData<TableDataWrapper>
    fun getPrayerTime(query: Query)
}