package com.gilorroristore.horoscapplication.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel
import com.gilorroristore.horoscapplication.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) : ViewModel() {

    /* Creand el mutable para arrancar la pantalla con un estado inicial */
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    fun getHoroscope (horoscopeModel: HoroscopeModel){

        //sino se pone ningun Dispatcher por defecto es el hilo principal viewModelScope.launch(Dispatchers.IO)
        viewModelScope.launch {
            _state.value = HoroscopeDetailState.Loading
            // Hilo principal

            withContext(Dispatchers.IO) {
                val result = getPredictionUseCase(horoscopeModel.name)

                if (result!= null){
                    _state.value = HoroscopeDetailState.Success( result.horoscope, result.sign, horoscopeModel)
                } else{
                    _state.value = HoroscopeDetailState.Error("Error encontrado")
                }
            }
        }
    }
}