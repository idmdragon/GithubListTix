package com.idmdragon.githublist.data.network

import com.google.gson.Gson
import com.idmdragon.githublist.data.response.ApiResponse
import com.idmdragon.githublist.data.response.ErrorResponse
import com.idmdragon.githublist.data.response.PagingDataResponse
import com.idmdragon.githublist.data.response.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getListUser(page: Int) : PagingDataResponse<UserResponse> =
        apiService.getListUser(username = "a", page = page, per_page = 10)

    fun getDetailUser(username: String): Flow<ApiResponse<UserResponse>> =
        flow {
            try {
                val response = apiService.getDetailUser(username)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)

}