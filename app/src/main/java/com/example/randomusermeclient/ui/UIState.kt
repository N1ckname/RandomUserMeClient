package com.example.randomusermeclient.ui

sealed interface ScreenUiState {
    data class Success (val data: Any) : ScreenUiState
    object Error : ScreenUiState
    object Loading : ScreenUiState
}