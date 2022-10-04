package uz.gita.namozvaqtlari.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.namozvaqtlari.data.local.entity.PrayerTimeEntity
import uz.gita.namozvaqtlari.data.local.entity.Query
import uz.gita.namozvaqtlari.data.utils.ResultData

interface Repository {

    fun getMonthlyPrayerTime(query: Query): Flow<List<PrayerTimeEntity>>

    suspend fun sync(query: Query)
}