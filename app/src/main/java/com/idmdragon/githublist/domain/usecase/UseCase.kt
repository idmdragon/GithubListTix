package com.idmdragon.githublist.domain.usecase

import androidx.paging.PagingData
import com.idmdragon.githublist.data.Resource
import com.idmdragon.githublist.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun getListUser(): Flow<PagingData<User>>
    fun getDetailUser(username: String): Flow<Resource<User>>
}