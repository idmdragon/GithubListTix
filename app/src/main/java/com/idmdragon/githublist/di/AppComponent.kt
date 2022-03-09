package com.idmdragon.githublist.di

import com.idmdragon.githublist.data.di.CoreComponent
import com.idmdragon.githublist.ui.activities.ListActivity
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(activity: ListActivity)
}