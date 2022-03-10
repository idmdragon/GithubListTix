package com.idmdragon.githublist.domain.repository

import androidx.paging.PagingData
import com.idmdragon.githublist.data.Resource
import com.idmdragon.githublist.domain.model.User
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getListUser(): Flow<PagingData<User>>
    fun getDetailUser(username: String): Flow<Resource<User>>
}