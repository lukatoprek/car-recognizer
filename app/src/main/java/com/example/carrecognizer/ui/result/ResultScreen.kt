package com.example.carrecognizer.ui.result

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ResultScreen(
    image: ByteArray,
    viewModel: ResultViewModel = viewModel()
) {
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(image) {
        viewModel.analyze(image)
    }

    when {
        state.isLoading -> CircularProgressIndicator()
        state.error != null -> Text(state.error!!)
        state.result != null -> {
            val result = state.result!!
            Column {
                Text("Brand: ${result.brand}")
                Text("Model: ${result.model}")
                Text("Confidence: ${(result.confidence * 100).toInt()}%")
            }
        }
    }
}