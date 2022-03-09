package com.idmdragon.githublist.data.network

import com.google.gson.Gson
import com.idmdragon.githublist.data.response.ApiResponse
import com.idmdragon.githublist.data.response.ErrorResponse
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

    fun getListUser(): Flow<ApiResponse<List<UserResponse>>> =
        flow {
            try {
                val response = apiService.getListUser()
                emit(ApiResponse.Success(response))

            } catch (t: Throwable) {
                when (t) {
                    is HttpException -> {
                        val errorResponse = Gson().fromJson(
                            t.response()?.errorBody()?.charStream(),
                            ErrorResponse::class.java
                        )
                        emit(ApiResponse.Error(errorResponse.message))
                    }
                    else -> {
                        emit(ApiResponse.Error(t.message.toString()))
                    }
                }
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