package com.idmdragon.githublist.data.di

import com.idmdragon.githublist.domain.repository.Repository
import com.idmdragon.githublist.data.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repositoryImpl: RepositoryImpl): Repository

}