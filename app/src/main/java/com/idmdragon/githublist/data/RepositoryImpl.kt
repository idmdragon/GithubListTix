package com.idmdragon.githublist.data

import com.idmdragon.githublist.data.network.DataSource
import com.idmdragon.githublist.data.response.ApiResponse
import com.idmdragon.githublist.data.response.UserResponse
import com.idmdragon.githublist.domain.model.User
import com.idmdragon.githublist.domain.repository.Repository
import com.idmdragon.githublist.mapper.toModel
import com.idmdragon.githublist.mapper.toModels
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(private val dataSource: DataSource) : Repository {
    override fun getListUser(): Flow<Resource<List<User>>> =
        object : NetworkResource<List<User>, List<UserResponse>>() {
            override fun convertResponseToModel(response: List<UserResponse>): List<User> =
                response.toModels()

            override suspend fun createCall(): Flow<ApiResponse<List<UserResponse>>> =
                dataSource.getListUser()

        }.asFlow()

    override fun getDetailUser(username: String): Flow<Resource<User>> =
        object : NetworkResource<User, UserResponse>() {
            override fun convertResponseToModel(response: UserResponse): User =
                response.toModel()

            override suspend fun createCall(): Flow<ApiResponse<UserResponse>> =
                dataSource.getDetailUser(username)

        }.asFlow()
}