package com.example.randomusermeclient.ui

sealed interface ScreenUiState {
    data class Success(val data: Any) : ScreenUiState
    data class Error(val message: String) : ScreenUiState
    data object Loading : ScreenUiState
}