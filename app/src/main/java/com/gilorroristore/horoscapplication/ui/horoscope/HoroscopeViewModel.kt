package com.gilorroristore.horoscapplication.ui.horoscope

import androidx.lifecycle.ViewModel
import com.gilorroristore.horoscapplication.data.provider.HoroscopeProvider
import com.gilorroristore.horoscapplication.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>> (emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    /* Similar al onCreate, ya que se inicia al arrancar el VM */
    init {
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }
}