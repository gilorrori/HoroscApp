package com.gilorroristore.horoscapplication.ui.detail

import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel

/**
 * Clase tipo facade para la presentación de estados en la vista, pueden agregarse más dependiendo la
 * logica del nogocio
 */
sealed class HoroscopeDetailState {
    data object Loading: HoroscopeDetailState()
    //Cuando hay que pasar parámentros hay que definir como data class, si es sencilla puede ser data ob.
    data class Error(val error: String): HoroscopeDetailState()
    data class Success(val prediction: String, val sign: String, val horoscopeModel: HoroscopeModel): HoroscopeDetailState()
}