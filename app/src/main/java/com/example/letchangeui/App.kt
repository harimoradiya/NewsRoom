package com.example.letchangeui

import android.app.Application
import com.example.letchangeui.di.networkModule
import com.example.letchangeui.di.repositoryModule
import com.example.letchangeui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }

    }
}