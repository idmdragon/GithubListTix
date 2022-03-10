package com.idmdragon.githublist.data.network

import com.idmdragon.githublist.data.response.PagingDataResponse
import com.idmdragon.githublist.data.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/search/users")
    suspend fun getListUser(
        @Query("q")username: String,
        @Query("page") page: Int,
        @Query("per_page") per_page:Int
    ): PagingDataResponse<UserResponse>

    @GET("/users/{user}")
    suspend fun getDetailUser(
        @Path("user")
        username: String
    ):UserResponse

}