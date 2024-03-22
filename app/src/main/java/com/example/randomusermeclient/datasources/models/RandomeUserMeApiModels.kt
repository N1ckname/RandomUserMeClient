package com.example.randomusermeclient.datasources.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.ApiStatus.Experimental

@Experimental
@Serializable
data class RandomUserMeApiResponse(
    @SerialName(value = "results")
    val users: List<User>,
    @SerialName(value = "info")
    val requestInfo: RequestInfo
)

/*
* Constructors' default values in conjunction with the API response parser setting
* provide a mitigation strategy for nullable values in responses.
 */
@Serializable
data class User(
    val gender: String = "",
    @SerialName(value = "name")
    val fullName: FullName = FullName(),
    val location: Location = Location(),
    val email: String = "",
    @SerialName(value = "login")
    val loginInfo: LoginInfo = LoginInfo(),
    val dob: DateOfBirth = DateOfBirth(),
    val registered: RegistrationInfo = RegistrationInfo(),
    val phone: String = "",
    val cell: String = "",
    @SerialName(value = "id")
    val personalId: PersonalId = PersonalId(),
    @SerialName(value = "picture")
    val picturesSources: PicturesSources = PicturesSources(),
    @SerialName(value = "nat")
    val nationality: String = "",
) {
    @Serializable
    data class FullName(
        val title: String = "",
        @SerialName("first")
        val firstName: String = "",
        @SerialName("last")
        val lastName: String = ""
    )

    @Serializable
    data class Location(
        val street: Street = Street(),
        val city: String = "",
        val state: String = "",
        val country: String = "",
        val postcode: String = "",
        val coordinates: Coordinates = Coordinates(),
        val timezone: Timezone = Timezone()
    ) {
        @Serializable
        data class Street(
            val number: Int = -1,
            val name: String = "",
        )

        @Serializable
        data class Coordinates(
            val latitude: String = "",
            val longitude: String = ""
        )

        @Serializable
        data class Timezone(
            val offset: String = "",
            val description: String = ""
        )
    }

    @Serializable
    data class LoginInfo(
        val uuid: String = "",
        val username: String = "",
        val password: String = "",
        val salt: String = "",
        val md5: String = "",
        val sha1: String = "",
        val sha256: String = ""
    )

    @Serializable
    data class DateOfBirth(
        val date: String = "",
        val age: Int = -1
    )

    @Serializable
    data class RegistrationInfo(
        val date: String = "",
        @SerialName(value = "age")
        val fullYearsSinceRegistration: Int = -1
    )

    @Serializable
    data class PersonalId(
        @SerialName(value = "name")
        val documentName: String = "",
        @SerialName(value = "value")
        val documentNumber: String = ""
    )

    @Serializable
    data class PicturesSources(
        val large: String = "",
        val medium: String = "",
        val thumbnail: String = ""
    )
}

@Serializable
data class RequestInfo(
    @SerialName(value = "seed")
    val requestSeed: String,
    @SerialName(value = "results")
    val resultsQuantity: Int,
    @SerialName(value = "page")
    val pagesQuantity: Int,
    @SerialName(value = "version")
    val apiVersion: String
)