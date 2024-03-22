package com.example.randomusermeclient.datasources

import com.example.randomusermeclient.datasources.models.RandomUserMeApiResponse
import com.example.randomusermeclient.datasources.models.User
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://randomuser.me/"

private val jsonParser = Json {
    //workaround for values' format inconsistency issue: https://github.com/RandomAPI/Randomuser.me-Node/issues/210
    isLenient = true
    coerceInputValues = true
}

private val networkApiFactory = Retrofit.Builder()
    .addConverterFactory(jsonParser.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface RandomUserMeApi {
    @GET("api/1.4/?results=50&seed=abc")
    suspend fun getUsers(): RandomUserMeApiResponse
}

object RemoteDataSource {
    private val RandomUserMeApiImpl by lazy {
        networkApiFactory.create(RandomUserMeApi::class.java)
    }

    suspend fun getUsers(): List<User> = RandomUserMeApiImpl.getUsers().users
}