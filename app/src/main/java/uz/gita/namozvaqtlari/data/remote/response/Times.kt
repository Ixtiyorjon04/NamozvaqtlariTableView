package uz.gita.namozvaqtlari.data.remote.response

import uz.gita.namozvaqtlari.data.local.entity.TimeEntity

data class Times(
    val asr: String,
    val hufton: String,
    val peshin: String,
    val quyosh: String,
    val shom_iftor: String,
    val tong_saharlik: String
) {
    fun toEntity() =
        TimeEntity(
            earlyMorning = tong_saharlik,
            sun = quyosh,
            noon = peshin,
            century = asr,
            evening = shom_iftor,
            night = hufton
        )
}