package com.example.pv_enhancer.data.openweather.repository

import com.example.pv_enhancer.data.openweather.data.model.ResponseOpenweatherDataModel
import com.example.pv_enhancer.data.openweather.data.model.Weather
import com.example.pv_enhancer.data.openweather.repository.network.openweather.OpenweatherNetwork
import javax.inject.Inject

// Original
class OpenweatherRepository @Inject constructor(private val network: OpenweatherNetwork) {
    suspend fun getAllWeather(): List<Weather> {
        return network.getAllWeather().weather
    }
}