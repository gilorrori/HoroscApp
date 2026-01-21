package com.gilorroristore.horoscapplication.data.network

import com.gilorroristore.horoscapplication.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{value}")
    suspend fun getHoroscope(@Path("value") sign: String): PredictionResponse
}