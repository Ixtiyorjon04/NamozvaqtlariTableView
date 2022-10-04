package uz.gita.namozvaqtlari.domain.repository.impl

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import uz.gita.namozvaqtlari.data.local.dao.PrayerTimeDao
import uz.gita.namozvaqtlari.data.local.entity.PrayerTimeEntity
import uz.gita.namozvaqtlari.data.local.entity.Query
import uz.gita.namozvaqtlari.data.remote.api.PrayerTimeApi
import uz.gita.namozvaqtlari.data.utils.MessageData
import uz.gita.namozvaqtlari.data.utils.ResultData
import uz.gita.namozvaqtlari.domain.repository.Repository
import uz.gita.newcontactapp.data.utils.hasConnection
import javax.inject.Inject
import javax.inject.Singleton

class RepositoryImpl @Inject constructor(
    val prayerTime: PrayerTimeDao,
    val prayerTimeApi: PrayerTimeApi
) : Repository {

    override fun getMonthlyPrayerTime(query: Query): Flow<List<PrayerTimeEntity>> =
        prayerTime.getMonthlyPrayerTime(query.region, query.month)

    override suspend fun sync(query: Query) {

        if (hasConnection()) {

            try {

                val response = prayerTimeApi.getPrayerTimeByMonth(query.region, query.month)

                Log.d("PPP", response.code().toString())

                when (response.code()) {
                    in 200..299 -> {
                        val data = response.body()
                        prayerTime.insert(data!!.map {
                            Log.d("PPP", it.weekday)
                            it.toEntity()
                        })
                    }
                    else -> {

                    }
                }
            } catch (e: Exception) {
                Log.d("PPP", e.toString())
            }

        } else {

        }

    }
}