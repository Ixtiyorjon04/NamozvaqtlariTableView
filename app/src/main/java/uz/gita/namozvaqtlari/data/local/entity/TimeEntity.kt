package uz.gita.namozvaqtlari.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

data class TimeEntity(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int,
    val earlyMorning: String,
    val sun: String,
    val noon: String,
    val century: String,
    val evening: String,
    val night: String
)