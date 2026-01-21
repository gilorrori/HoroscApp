package com.gilorroristore.horoscapplication.domain.usecase

import com.gilorroristore.horoscapplication.domain.Repository
import com.gilorroristore.horoscapplication.domain.model.HoroscopeModel
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke (sign: String) = repository.getPrediction(sign)

}