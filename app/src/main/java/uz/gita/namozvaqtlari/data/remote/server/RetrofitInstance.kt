package uz.gita.namozvaqtlari.data.remote.server

import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.namozvaqtlari.app.App

object RetrofitInstance {


    val retrofit by lazy {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder().addInterceptor(logging)
            .addInterceptor(ChuckerInterceptor(App.instance)).build()

        Retrofit.Builder()
            .baseUrl("http://cbu.uz/uzc/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}
