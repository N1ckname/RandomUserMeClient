package com.example.randomusermeclient.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.randomusermeclient.datasources.UserDataSource
import com.example.randomusermeclient.models.SingleUser
import com.example.randomusermeclient.models.UserSummary

class UsersViewModel: ViewModel() {
    private val _users = UserDataSource.getUsers().shuffled().toMutableStateList()
    val users: List<UserSummary>
        get() = _users

    fun getUser(userId: Int): State<SingleUser> = mutableStateOf(UserDataSource.getUser(userId))
}