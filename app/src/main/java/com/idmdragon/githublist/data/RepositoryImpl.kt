package com.idmdragon.githublist.data

import com.idmdragon.githublist.data.network.DataSource
import com.idmdragon.githublist.domain.model.User
import com.idmdragon.githublist.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(private val dataSource: DataSource) : Repository {
    override fun getListUser(): Flow<Resource<List<User>>> {
        TODO("Not yet implemented")
    }

    override fun getDetailUser(username: String): Flow<Resource<User>> {
        TODO("Not yet implemented")
    }
}