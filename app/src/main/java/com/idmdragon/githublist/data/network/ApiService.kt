package com.idmdragon.githublist.data.network

import com.idmdragon.githublist.data.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/users")
    suspend fun getListUser(): List<UserResponse>

    @GET("/users/{user}")
    suspend fun getDetailUser(
        @Path("user")
        username: String
    ):UserResponse

}