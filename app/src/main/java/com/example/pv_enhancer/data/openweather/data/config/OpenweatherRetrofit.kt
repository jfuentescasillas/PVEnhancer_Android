package com.example.pv_enhancer.data.openweather.data.config

import com.example.pv_enhancer.BuildConfig
import com.example.pv_enhancer.base.util.NetworkManager
import com.example.pv_enhancer.base.util.NoInternetException
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class OpenweatherRetrofit @Inject constructor(private val networkManager: NetworkManager) {
    fun loadRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(createHttpClient())
            .build()
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
            val lat = 40.3871
            val lon = 3.7546
            var request = chain.request()
            val url = request.url.newBuilder()
                .addQueryParameter("lat", lat.toString())
                .addQueryParameter("lon", lon.toString())
                .build()

            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }

        return builder.build()
    }
}