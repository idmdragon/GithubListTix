package com.idmdragon.githublist.data

import com.idmdragon.githublist.data.response.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkResource<ResultType, RequestType> {

    private val result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ApiResponse.Success -> {
                onFetchSuccess()
                emit(Resource.Success(convertResponseToModel(apiResponse.data)))
            }
            is ApiResponse.Error -> {
                emit(
                    Resource.Error<ResultType>(
                        apiResponse.message
                    )
                )
            }
        }
    }

    protected abstract fun convertResponseToModel(response: RequestType): ResultType

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected open suspend fun onFetchSuccess() {}

    protected open suspend fun onFetchFailed() {}

    fun asFlow() = result

}