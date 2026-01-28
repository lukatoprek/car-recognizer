package com.example.carrecognizer.data

import javax.inject.Inject

class CarRecognizer @Inject constructor(
    private val apiRepository: ApiRepository
) {
    suspend fun recognizeCar(image: ByteArray): Result {
        return apiRepository.predictCar(image)
    }
}