package uz.gita.namozvaqtlari.data.remote.request

import uz.gita.namozvaqtlari.data.local.entity.TimeEntity

data class TimeRequest(
    val earlyMorning: String,
    val sun: String,
    val noon: String,
    val century: String,
    val evening: String,
    val night: String
) {
    fun toEntity() = TimeEntity(

        earlyMorning = earlyMorning,
        sun = sun,
        noon = noon,
        century = century,
        evening = evening,
        night = night
    )
}