package uz.gita.namozvaqtlari.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.gita.namozvaqtlari.data.remote.request.TimeRequest

@Entity(tableName = "prayer_time")
data class PrayerTimeEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val region: String,
    val month: Int,
    val day: Int,
    val weekday: String,
    @Embedded
    val times: TimeEntity,
    val date: String
)