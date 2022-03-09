package com.idmdragon.githublist.data.network

import com.idmdragon.githublist.data.response.ApiResponse
import com.idmdragon.githublist.data.response.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSource @Inject constructor(private val apiService: ApiService) {

    fun getListUser(): Flow<ApiResponse<List<UserResponse>>> =
        flow {
            try {
                val response = apiService.getListUser()
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)

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