package com.example.carrecognizer.data

import android.util.Log
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun predictCar(imageBytes: ByteArray): Result {
        return try {
            val base64Image = android.util.Base64.encodeToString(imageBytes, android.util.Base64.DEFAULT)

            val request = CarPredictionRequest(
                image = base64Image,
            )

            val response = apiService.predictCar(
                authorization = ApiClient.getAuthHeader(),
                request = request
            )

            if (response.isSuccessful) {
                val apiResponse = response.body()
                apiResponse?.let {
                    Result(
                        model_name = it.model_name ?: "Unknown",
                        confidence = it.confidence ?: 0.0f
                    )
                } ?: throw Exception("Empty response from API")
            } else {
                val errorBody = response.errorBody()?.string()
                Log.e("ApiRepository", "API Error: $errorBody")
                throw Exception("API Error: ${response.code()} - $errorBody")
            }
        } catch (e: Exception) {
            Log.e("ApiRepository", "Error calling API", e)
            throw e
        }
    }
}