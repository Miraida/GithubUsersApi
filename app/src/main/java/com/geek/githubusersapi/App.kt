package com.geek.githubusersapi

import android.app.Application
import com.geek.githubusersapi.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(koinModules)
        }
    }
}