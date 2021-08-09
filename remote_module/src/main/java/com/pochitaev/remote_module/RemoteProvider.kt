package com.pochitaev.remote_module

interface RemoteProvider {
    fun provideRemote(): TmdbApi
}