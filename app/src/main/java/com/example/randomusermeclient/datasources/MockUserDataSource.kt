package com.example.randomusermeclient.datasources

import com.example.randomusermeclient.models.SingleUser
import com.example.randomusermeclient.models.UserSummary

object MockUserDataSource {
    private val users: List<UserSummary> = List(10) { id ->
        UserSummary(
            id = id.toString(),
            fullName = "${"A".repeat(id + 1)} ${"B".repeat(id + 1)} ${"C".repeat(id + 1)}",
            address = "Smae Addeer, $id/$id",
            phone = "+ ${(id + 1)} ${id.toString().repeat(10)}"
        )
    }

    fun getUsers() = users

    fun getUser(id: String): SingleUser =
        SingleUser(
            basis = users.firstOrNull { userSummary -> id == userSummary.id } ?: UserSummary(id = "")
        )
}