package com.gilorroristore.horoscapplication.data.network.response

import kotlinx.serialization.SerialName

data class HoroscopeResponse(

    @SerialName("horoscope") val horoscope: String,
    @SerialName("sign") val sign: String,
    @SerialName("icon") val icon: String
)
