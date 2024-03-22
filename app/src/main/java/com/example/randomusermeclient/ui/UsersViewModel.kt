package com.example.randomusermeclient.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomusermeclient.RandomUsersRepository
import com.example.randomusermeclient.models.UserSummary
import com.example.randomusermeclient.ui.ScreenUiState.Error
import com.example.randomusermeclient.ui.ScreenUiState.Loading
import com.example.randomusermeclient.ui.ScreenUiState.Success
import kotlinx.coroutines.launch

class UsersViewModel : ViewModel() {
    var currentScreenState: ScreenUiState by  mutableStateOf(Loading)
        private set

    private val usersRepository = RandomUsersRepository()

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            currentScreenState = Loading
            currentScreenState = try {
                val usersSummaries = usersRepository.getUsers().map { item -> UserSummary(item.basis.id) }
                Success(data = usersSummaries)
            } catch (error: Throwable) {
                Error(message = error.message ?: "")
            }
        }
    }

    fun getUser(userId: String) {
        viewModelScope.launch {
            currentScreenState = Loading
            currentScreenState = try {
                Success(data = usersRepository.getUser(userId))
            } catch (error: Throwable) {
                Error(message = error.message ?: "")
            }
        }
    }
}