package com.example.randomusermeclient.datasources

import com.example.randomusermeclient.datasources.models.User
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://randomuser.me/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface RandomUserMeApiService {
    @GET("api")
    fun getUsers(): User
}

object RemoteDataSource {
    private val retrofitService by lazy {
        retrofit.create(RandomUserMeApiService::class.java)
    }

    fun getUsers(): User = retrofitService.getUsers()
}