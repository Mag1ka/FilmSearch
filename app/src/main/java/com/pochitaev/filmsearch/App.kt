package com.pochitaev.filmsearch

import android.app.Application
import com.pochitaev.filmsearch.di.DaggerAppComponent
import com.pochitaev.filmsearch.di.AppComponent
import com.pochitaev.filmsearch.di.modules.DatabaseModule
import com.pochitaev.filmsearch.di.modules.DomainModule
import com.pochitaev.remote_module.DaggerRemoteComponent


class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        val remoteProvider = DaggerRemoteComponent.create()
        dagger = DaggerAppComponent.builder()
            .remoteProvider(remoteProvider)
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}