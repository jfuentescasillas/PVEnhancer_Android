package com.example.pv_enhancer.presentation.fragment.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pv_enhancer.data.openweather.repository.OpenweatherRepository
import kotlinx.coroutines.launch


class ListViewModel: ViewModel() {
    fun requestInformation() {
        viewModelScope.launch {
            OpenweatherRepository().getAllWeather()
        }
    }
}