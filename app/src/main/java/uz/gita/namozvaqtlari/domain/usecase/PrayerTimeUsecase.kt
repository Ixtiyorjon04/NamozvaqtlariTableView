package uz.gita.namozvaqtlari.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.namozvaqtlari.data.local.entity.PrayerTimeEntity
import uz.gita.namozvaqtlari.data.local.entity.Query

interface PrayerTimeUseCase {

    fun getMonthlyPayerTime(query: Query): Flow<List<PrayerTimeEntity>>

    suspend fun sync(query: Query)
}