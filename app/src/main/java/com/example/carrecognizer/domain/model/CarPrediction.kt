package com.example.carrecognizer.domain.model

data class CarPrediction(
    val brand: String,
    val model: String,
    val confidence: Float
)