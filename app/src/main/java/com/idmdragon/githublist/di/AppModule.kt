package com.idmdragon.githublist.di

import com.idmdragon.githublist.domain.usecase.Interactor
import com.idmdragon.githublist.domain.usecase.UseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideUseCase(interactor: Interactor): UseCase

}
