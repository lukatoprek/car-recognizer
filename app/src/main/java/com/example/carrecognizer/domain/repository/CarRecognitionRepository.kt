package com.example.carrecognizer.domain.repository

import com.example.carrecognizer.domain.model.CarPrediction

interface CarRecognitionRepository {
    suspend fun recognizeCar(image: ByteArray): CarPrediction
}