package uz.gita.namozvaqtlari.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.gita.namozvaqtlari.data.remote.api.PrayerTimeApi
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun getPrayerTimeApi(retrofit: Retrofit):PrayerTimeApi = retrofit.create(PrayerTimeApi::class.java)

}