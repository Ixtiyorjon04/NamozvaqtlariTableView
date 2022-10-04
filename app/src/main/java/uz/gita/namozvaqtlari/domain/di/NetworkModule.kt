package uz.gita.namozvaqtlari.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.gita.namozvaqtlari.data.remote.server.RetrofitInstance


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun getRetrofit(): Retrofit = RetrofitInstance.retrofit

}