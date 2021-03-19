package com.example.pv_enhancer.data.openweather.repository.network

import retrofit2.http.GET
import retrofit2.http.Query


interface OpenweatherService {
    @GET("data/2.5/weather")
    suspend fun getAllCharacters(@Query("lat") lat: Double, @Query("lon") lon: Double)
}