package com.example.carrecognizer.data.remote

import com.example.carrecognizer.domain.model.CarPrediction
import kotlinx.coroutines.delay

class MockApiService {
    suspend fun predict(image: ByteArray): CarPrediction {
        delay(1500)
        return CarPrediction(
            brand = "Volkswagen",
            model = "Golf 7",
            confidence = 0.82f
        )
    }
}