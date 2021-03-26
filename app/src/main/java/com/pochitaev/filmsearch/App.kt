package com.pochitaev.filmsearch

import android.app.Application
import android.content.res.Configuration
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }
    override fun onConfigurationChanged ( newConfig : Configuration) {
        super.onConfigurationChanged(newConfig)
    }
    override fun onLowMemory() {
        super.onLowMemory()
    }
    class LifeCycleListener : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun start() {


        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun stop() {

        }
    }
}