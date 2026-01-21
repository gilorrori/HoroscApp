package com.gilorroristore.horoscapplication.data.network

import com.gilorroristore.horoscapplication.BuildConfig
import com.gilorroristore.horoscapplication.data.RepositoryImpl
import com.gilorroristore.horoscapplication.domain.Repository
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
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Se pasa directamente un objeto Retrofit ya que dagger examinara si la clase principal de retrofit
     * tiene un @Inject constructor() y sino lo tiene entonces buscarà un provider en sus módulos el cual
     * es el creado manualmente como providesRetrofit()
     */
    @Provides
    @Singleton
    fun provideHoroscopeApi(retrofit: Retrofit) : HoroscopeApiService {
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(apiService: HoroscopeApiService) : Repository{
        return RepositoryImpl(apiService)
    }

}