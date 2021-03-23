package com.example.pv_enhancer.presentation.fragment.list


import com.example.pv_enhancer.base.BaseViewModel
import com.example.pv_enhancer.data.openweather.repository.NasaRepository
import com.example.pv_enhancer.data.openweather.repository.OpenweatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ListViewModel@Inject constructor(private val repository: OpenweatherRepository, private val repository2: NasaRepository): BaseViewModel<ListState>() {
    override val defaultState: ListState = ListState()


    override fun onStartFirstTime() {
        requestInformationOpenweather()
        requestInformationNASA()
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

        checkDataState { state ->
            executeCoroutines({
                val response = repository2.getAllIrradiances().featureIrradiances
                updateToNormalState(state.copy(nasaList = response))
            }, { error ->
                updateToErrorState(error)
            })
        }
    }
}