package com.example.carrecognizer.data

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("score")
    suspend fun predictCar(
        @Header("Authorization") authorization: String,
        @Header("Content-Type") contentType: String = "application/json",
        @Body request: CarPredictionRequest
    ): Response<CarPredictionResponse>
}

data class CarPredictionRequest(
    val image: String? = null,
)

data class CarPredictionResponse(
    val model_name: String? = null,
    val confidence: Float? = null,
)