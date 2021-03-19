package com.example.pv_enhancer.data.openweather.repository

import com.example.pv_enhancer.data.openweather.data.model.ResponseOpenweatherDataModel
import com.example.pv_enhancer.data.openweather.repository.network.OpenweatherNetwork


class OpenweatherRepository {
    suspend fun getAllWeather(): ResponseOpenweatherDataModel {
        return OpenweatherNetwork().getAllWeather()
    }
}