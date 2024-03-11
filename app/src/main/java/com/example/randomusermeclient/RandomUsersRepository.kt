package com.example.randomusermeclient

import com.example.randomusermeclient.datasources.RemoteDataSource
import com.example.randomusermeclient.models.SingleUser
import com.example.randomusermeclient.models.UserSummary

class RandomUsersRepository {

    private val users: MutableList<SingleUser> = mutableListOf()
    suspend fun getUsers() {
        repeat(25) { _ ->
            users.add(
                RemoteDataSource.getUsers().let { SingleUser(UserSummary(1)) }
            )
        }
    }
    suspend fun getUser(userId: Int): Any {
        return users.first { user -> user.basis.id == userId }
    }
}