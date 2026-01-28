package com.example.carrecognizer.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrecognizer.data.ApiClient
import com.example.carrecognizer.data.ApiRepository
import com.example.carrecognizer.data.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.carrecognizer.data.CarRecognizer
import com.example.carrecognizer.data.Result
import java.io.IOException
import java.net.SocketTimeoutException

data class ResultState(
    val isLoading: Boolean = false,
    val result: Result? = null,
    val error: String? = null
)

object AppContainer {
    private val apiService: ApiService by lazy { ApiClient.apiService }
    private val apiRepository: ApiRepository by lazy { ApiRepository(apiService) }
    val carRecognizer: CarRecognizer by lazy { CarRecognizer(apiRepository) }
}

class SharedViewModel(
    private val carRecognizer: CarRecognizer = AppContainer.carRecognizer
) : ViewModel() {

    var capturedImage: ByteArray? = null

    private val _state = MutableStateFlow(ResultState())
    val state: StateFlow<ResultState> = _state

    fun analyze(image: ByteArray) {
        viewModelScope.launch {
            _state.value = ResultState(isLoading = true)

            try {
                val result = carRecognizer.recognizeCar(image)
                _state.value = ResultState(
                    isLoading = false,
                    result = result,
                    error = null
                )
            } catch (e: SocketTimeoutException) {
                _state.value = ResultState(
                    isLoading = false,
                    error = "Request timed out. Please check your connection."
                )
            } catch (e: IOException) {
                _state.value = ResultState(
                    isLoading = false,
                    error = "Network error. Please check your internet connection."
                )
            } catch (e: Exception) {
                _state.value = ResultState(
                    isLoading = false,
                    error = "Error: ${e.message ?: "Unknown error occurred"}"
                )
            }
        }
    }
}