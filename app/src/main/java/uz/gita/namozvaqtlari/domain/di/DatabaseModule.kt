package uz.gita.namozvaqtlari.domain.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.namozvaqtlari.data.local.dao.PrayerTimeDao
import uz.gita.namozvaqtlari.data.local.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @[Provides Singleton]
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "prayer.db").build()

    @[Provides Singleton]
    fun providePrayerTimeDao(appDatabase: AppDatabase): PrayerTimeDao = appDatabase.dao()
}