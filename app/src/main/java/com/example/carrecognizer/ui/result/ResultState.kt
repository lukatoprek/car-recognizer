package com.example.carrecognizer.ui.result

import com.example.carrecognizer.domain.model.CarPrediction

data class ResultState(
    val isLoading: Boolean = false,
    val result: CarPrediction? = null,
    val error: String? = null
)