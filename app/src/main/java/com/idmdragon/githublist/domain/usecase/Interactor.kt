package com.idmdragon.githublist.domain.usecase

import androidx.paging.PagingData
import com.idmdragon.githublist.domain.repository.Repository
import com.idmdragon.githublist.data.Resource
import com.idmdragon.githublist.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Interactor @Inject constructor(private val repository: Repository) : UseCase {

    override fun getListUser(): Flow<PagingData<User>> =
        repository.getListUser()

    override fun getDetailUser(username: String): Flow<Resource<User>> =
        repository.getDetailUser(username)
}