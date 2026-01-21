package com.gilorroristore.horoscapplication.domain.model

import kotlinx.serialization.SerialName

data class PredictionModel (
    val date: String,
    val horoscope: String,
    val sign: String,
    val icon: String
)