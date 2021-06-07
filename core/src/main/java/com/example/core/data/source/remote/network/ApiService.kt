package com.example.core.data.source.remote.network

import com.example.core.data.source.remote.response.ListGameResponse
import retrofit2.http.GET

interface ApiService {

    @GET("games?key=8d75e3eaf8f94651bef7448b5731fd1a")
    suspend fun getList(): ListGameResponse

}