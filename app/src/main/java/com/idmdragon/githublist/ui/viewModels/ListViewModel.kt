package com.idmdragon.githublist.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import com.idmdragon.githublist.data.Resource
import com.idmdragon.githublist.domain.model.User
import com.idmdragon.githublist.domain.usecase.UseCase

class ListViewModel(private val useCase: UseCase) : ViewModel() {

    fun getListUser(): LiveData<PagingData<User>> =
        useCase.getListUser().asLiveData()

    fun getDetailUser(username: String) : LiveData<Resource<User>> =
        useCase.getDetailUser(username).asLiveData()
}