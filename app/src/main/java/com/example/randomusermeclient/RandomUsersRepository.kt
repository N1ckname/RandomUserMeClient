package com.example.randomusermeclient

import com.example.randomusermeclient.datasources.RemoteDataSource
import com.example.randomusermeclient.models.SingleUser
import com.example.randomusermeclient.models.UserSummary

class RandomUsersRepository {

    private val users: MutableList<SingleUser> = mutableListOf()
    suspend fun getUsers(): List<SingleUser> {
        users.addAll(
            RemoteDataSource.getUsers().map { item ->
                SingleUser(
                    UserSummary(
                        id = item.loginInfo.uuid,
                    )
                )
            }
        )

        return users
    }

    suspend fun getUser(userId: String): Any {
        return users.first { user -> user.basis.id == userId }
    }
}