package com.example.pv_enhancer.data.openweather.repository.network.openweather

import com.example.pv_enhancer.BuildConfig
import com.example.pv_enhancer.base.util.NetworkManager
import com.example.pv_enhancer.base.util.NoInternetException
import com.example.pv_enhancer.data.openweather.data.model.ResponseOpenweatherDataModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class OpenweatherNetwork @Inject constructor(private val networkManager: NetworkManager) {
    lateinit var service: OpenweatherService

    private fun loadRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(createHttpClient())
            .build()

        service = retrofit.create(OpenweatherService::class.java)
    }


    suspend fun getAllWeather(): ResponseOpenweatherDataModel {
        loadRetrofit()

        return service.getAllWeather()
    }


    private fun createHttpClient(): OkHttpClient {
        // Create OkHttpClient
        val builder = OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)

        // Logger Interceptor
        val loggerInterceptor = HttpLoggingInterceptor()
        loggerInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        builder.addInterceptor(loggerInterceptor)

        // Check internet connection
        val checkInternetConnectivityInterceptor = Interceptor {
            if(!networkManager.isNetworkAvailable()) {
                throw NoInternetException()
            }

            it.proceed((it.request()))
        }

        builder.addInterceptor(checkInternetConnectivityInterceptor)

        // App token
        builder.addInterceptor { chain ->
            val appid = "773b88d704e3fbd8e4864b1ea1e84a47"
            val lat = 40.3871
            val lon = -3.7546
            var request = chain.request()
            val url = request.url.newBuilder()
                .addQueryParameter("lat", lat.toString())
                .addQueryParameter("lon", lon.toString())
                .addQueryParameter("appid", appid)
                .build()

            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }

        return builder.build()
    }
}