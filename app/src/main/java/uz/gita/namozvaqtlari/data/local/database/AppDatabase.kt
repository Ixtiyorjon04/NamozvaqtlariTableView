package uz.gita.namozvaqtlari.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.namozvaqtlari.data.local.dao.PrayerTimeDao
import uz.gita.namozvaqtlari.data.local.entity.PrayerTimeEntity
import uz.gita.namozvaqtlari.data.local.entity.TimeEntity


@Database(entities = [PrayerTimeEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dao(): PrayerTimeDao
}