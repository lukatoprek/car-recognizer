package com.example.carrecognizer.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrecognizer.data.repository.CarRecognitionRepositoryImpl
import com.example.carrecognizer.domain.repository.CarRecognitionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ResultViewModel(
    private val repository: CarRecognitionRepository =
        CarRecognitionRepositoryImpl()
) : ViewModel() {

    private val _state = MutableStateFlow(ResultState())
    val state = _state.asStateFlow()

    fun analyze(image: ByteArray) {
        viewModelScope.launch {
            _state.value = ResultState(isLoading = true)

            try {
                val result = repository.recognizeCar(image)
                _state.value = ResultState(result = result)
            } catch (e: Exception) {
                _state.value = ResultState(error = e.message)
            }
        }
    }
}