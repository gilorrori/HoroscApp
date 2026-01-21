package com.gilorroristore.horoscapplication.domain

import com.gilorroristore.horoscapplication.data.network.response.PredictionResponse
import com.gilorroristore.horoscapplication.domain.model.PredictionModel

/**
 * Comunicacion entre la capa de Data y Domain
 *
 * AQUI SE DEFINEN LAS COSAS QUE SE NECESITARAN DE LA CAPA DATA PARA TRAER AL DOMAIN
 */
interface Repository {
    suspend fun getPrediction(sign: String) : PredictionModel?
}