package com.idmdragon.githublist.data.di

import android.content.Context
import com.idmdragon.githublist.domain.repository.Repository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository() : Repository
}