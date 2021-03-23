package com.example.pv_enhancer.presentation.fragment.list


import com.example.pv_enhancer.base.BaseViewModel
import com.example.pv_enhancer.data.openweather.repository.OpenweatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ListViewModel@Inject constructor(private val repository: OpenweatherRepository): BaseViewModel<ListState>() {
    override val defaultState: ListState = ListState()


    override fun onStartFirstTime() {
        requestInformationOpenweather()
    }


    private fun requestInformationOpenweather() {
        updateToLoadingState()

        checkDataState { state ->
            executeCoroutines({
                val response = repository.getAllWeather()
                updateToNormalState(state.copy(weatherList = response))
            }, { error ->
                updateToErrorState(error)
            })
        }
    }


    private fun requestInformationNASA() {
        updateToLoadingState()
    }
}