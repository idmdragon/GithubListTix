package com.idmdragon.githublist.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.idmdragon.githublist.di.AppScope
import com.idmdragon.githublist.domain.usecase.UseCase
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val useCase: UseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(ListViewModel::class.java) -> {
                ListViewModel(useCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}