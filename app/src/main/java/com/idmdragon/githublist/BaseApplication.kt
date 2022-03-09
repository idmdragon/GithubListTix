package com.idmdragon.githublist

import android.app.Application
import com.idmdragon.githublist.data.di.CoreComponent
import com.idmdragon.githublist.data.di.DaggerCoreComponent
import com.idmdragon.githublist.di.AppComponent
import com.idmdragon.githublist.di.DaggerAppComponent

open class BaseApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}