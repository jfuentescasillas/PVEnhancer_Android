package com.example.pv_enhancer.data.openweather.repository.network.openweather

import com.example.pv_enhancer.data.openweather.data.model.ResponseOpenweatherDataModel
import retrofit2.http.GET


interface OpenweatherService {
    @GET("data/2.5/weather")
    suspend fun getAllWeather(): ResponseOpenweatherDataModel
}