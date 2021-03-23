package com.example.pv_enhancer.data.openweather.repository.network.nasa

import com.example.pv_enhancer.data.openweather.data.model.ResponseNasaDataModel
import com.example.pv_enhancer.data.openweather.data.model.ResponseOpenweatherDataModel
import retrofit2.http.GET


interface NasaService {
    @GET("cgi-bin/v1/DataAccess.py")
    suspend fun getAllIrradiances(): ResponseNasaDataModel
}