package com.gilorroristore.horoscapplication.data.network.core.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val tokenManager: TokenManager) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        // Volviendo a crear el request pero con el header/valor/dato agregado a la peticion
        val request = chain.request()
            .newBuilder()
            .header("Authorization", tokenManager.getToken())
            .build()

        return chain.proceed(request)
    }
}

/*
* Deberia ser una clase aparte, para fines demostrativos se creó*/
class TokenManager @Inject constructor() {
    fun getToken(): String = ""
}