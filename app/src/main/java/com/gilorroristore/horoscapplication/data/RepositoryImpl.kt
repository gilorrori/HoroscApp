package com.gilorroristore.horoscapplication.data

import android.util.Log
import com.gilorroristore.horoscapplication.data.network.HoroscopeApiService
import com.gilorroristore.horoscapplication.domain.Repository
import com.gilorroristore.horoscapplication.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val horoscopeApiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {

        runCatching {
            horoscopeApiService.getHoroscope(sign)
        }.onSuccess {
            return it.toDomain()
        }.onFailure {
            Log.i("", "ocurrio un error ${it.message}")
        }
        return null
    }
}