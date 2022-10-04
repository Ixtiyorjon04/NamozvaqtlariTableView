package uz.gita.namozvaqtlari.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import uz.gita.namozvaqtlari.domain.usecase.PrayerTimeUseCase
import uz.gita.namozvaqtlari.domain.usecase.impl.PrayerTimeUseCaseImpl
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bind(impl: PrayerTimeUseCaseImpl): PrayerTimeUseCase
}