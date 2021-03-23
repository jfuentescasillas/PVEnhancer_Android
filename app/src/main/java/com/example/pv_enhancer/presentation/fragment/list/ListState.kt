package com.example.pv_enhancer.presentation.fragment.list

import com.example.pv_enhancer.base.BaseViewState
import com.example.pv_enhancer.data.openweather.data.model.ResponseOpenweatherDataModel
import com.example.pv_enhancer.data.openweather.data.model.Weather


data class ListState(
        val weatherList: List<Weather> = listOf()
): BaseViewState()