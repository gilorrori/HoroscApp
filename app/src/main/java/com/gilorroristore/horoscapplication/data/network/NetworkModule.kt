package com.gilorroristore.horoscapplication.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Accesible para all proyecto
object NetworkModule {


    @Provides // Para poder proveer a este objeto de una clase o sdk externo
    @Singleton // Una sola instancia del objeto en tod o el ciclo de la app
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}