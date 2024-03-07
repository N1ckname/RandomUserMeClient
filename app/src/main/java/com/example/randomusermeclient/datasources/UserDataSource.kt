package com.example.randomusermeclient.datasources

import com.example.randomusermeclient.models.SingleUser
import com.example.randomusermeclient.models.UserSummary

object UserDataSource {
    private val users: List<UserSummary> = List(10) { id ->
        UserSummary(
            id = id,
            fullName = "${"A".repeat(id + 1)} ${"B".repeat(id + 1)} ${"C".repeat(id + 1)}",
            address = "Smae Addeer, $id/$id",
            phone = "+ ${(id + 1)} ${id.toString().repeat(10)}"
        )
    }

    fun getUsers() = users

    fun getUser(id: Int): SingleUser =
        SingleUser(
            basis = users.firstOrNull { userSummary -> id == userSummary.id } ?: UserSummary(id = -1)
        )
}