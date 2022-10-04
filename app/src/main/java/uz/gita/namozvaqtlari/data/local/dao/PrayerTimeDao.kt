package uz.gita.namozvaqtlari.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.namozvaqtlari.data.local.entity.PrayerTimeEntity

@Dao
interface PrayerTimeDao : BaseDao<PrayerTimeEntity> {

    @Query("Select * From prayer_time Where prayer_time.region = :region and prayer_time.month = :month")
    fun getMonthlyPrayerTime(region: String, month: Int): Flow<List<PrayerTimeEntity>>
}