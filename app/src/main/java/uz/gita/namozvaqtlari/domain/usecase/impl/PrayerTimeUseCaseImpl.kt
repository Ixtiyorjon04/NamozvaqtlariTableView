package uz.gita.namozvaqtlari.domain.usecase.impl

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import uz.gita.namozvaqtlari.data.local.entity.PrayerTimeEntity
import uz.gita.namozvaqtlari.data.local.entity.Query
import uz.gita.namozvaqtlari.domain.repository.Repository
import uz.gita.namozvaqtlari.domain.usecase.PrayerTimeUseCase
import javax.inject.Inject

class PrayerTimeUseCaseImpl @Inject constructor(
    val repository: Repository
) :
    PrayerTimeUseCase {
    override fun getMonthlyPayerTime(query: Query): Flow<List<PrayerTimeEntity>> =
        repository.getMonthlyPrayerTime(query)

    override suspend fun sync(query: Query) {
        repository.sync(query)
    }
}