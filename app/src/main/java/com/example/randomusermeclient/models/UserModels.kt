package com.example.randomusermeclient.models

data class UserSummary(
    val id: String,
    val fullName: String = "",
    val address: String = "",
    val phone: String = "",
    val picture: String = ""
)

data class SingleUser(
    val basis: UserSummary
)