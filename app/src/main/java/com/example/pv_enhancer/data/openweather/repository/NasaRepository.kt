package com.example.pv_enhancer.data.openweather.repository

import com.example.pv_enhancer.data.openweather.data.model.FeatureIrradiances
import com.example.pv_enhancer.data.openweather.data.model.ResponseNasaDataModel
import com.example.pv_enhancer.data.openweather.data.model.ResponseOpenweatherDataModel
import com.example.pv_enhancer.data.openweather.repository.network.nasa.NasaNetwork
import javax.inject.Inject


class NasaRepository @Inject constructor(private val network: NasaNetwork) {
    suspend fun getAllIrradiances(): ResponseNasaDataModel {
        return network.getAllIrradiances()
    }
}