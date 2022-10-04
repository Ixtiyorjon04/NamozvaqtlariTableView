package uz.gita.namozvaqtlari.data.remote.response

import uz.gita.namozvaqtlari.data.local.entity.PrayerTimeEntity

data class PrayerTimeItem(
    val date: String,
    val day: Int,
    val month: Int,
    val region: String,
    val times: Times,
    val weekday: String
) {
    fun toEntity() = PrayerTimeEntity(

        date = date,
        day = day,
        month = month,
        region = region,
        times = times.toEntity(),
        weekday = weekday,
        id = 0
    )
}