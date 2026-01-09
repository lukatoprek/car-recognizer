package com.example.carrecognizer.data.repository

import com.example.carrecognizer.data.remote.MockApiService
import com.example.carrecognizer.domain.model.CarPrediction
import com.example.carrecognizer.domain.repository.CarRecognitionRepository

class CarRecognitionRepositoryImpl(
    private val api: MockApiService = MockApiService()
) : CarRecognitionRepository {

    override suspend fun recognizeCar(image: ByteArray): CarPrediction {
        return api.predict(image)
    }
}