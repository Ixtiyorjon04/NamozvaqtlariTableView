package uz.gita.namozvaqtlari.data.remote.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.gita.namozvaqtlari.data.remote.request.PrayerTimeRequest
import uz.gita.namozvaqtlari.data.remote.response.BaseResponse
import uz.gita.namozvaqtlari.data.remote.response.PrayerTime
import uz.gita.namozvaqtlari.data.remote.response.PrayerTimeItem

interface PrayerTimeApi {

    @GET("arkhiv-kursov-valyut/json/")
    fun getCurrency(): Call<List<PrayerTimeRequest>>
}