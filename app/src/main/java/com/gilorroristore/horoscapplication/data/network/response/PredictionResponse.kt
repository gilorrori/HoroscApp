package com.gilorroristore.horoscapplication.data.network.response

import com.gilorroristore.horoscapplication.domain.model.PredictionModel
import kotlinx.serialization.SerialName

data class PredictionResponse(
    // @SerialName ademas de ser buena práctica sirve para que no se ofusque el codigo
    @SerialName("date") val date: String,
    @SerialName("horoscope") val horoscope: String,
    @SerialName("sign") val sign: String,
    @SerialName("icon") val icon: String
) {
    fun toDomain() : PredictionModel{
        /* Haciendo el map para el response al modelo con fin de que no se pasen modelos entre capas */
        return PredictionModel(
            date = date,
            horoscope = horoscope,
            sign = sign,
            icon = icon
        )
    }
}
