package com.pochitaev.filmsearch.di.modules

import android.content.Context
import com.pochitaev.filmsearch.data.MainRepository
import com.pochitaev.filmsearch.data.PreferenceProvider
import com.pochitaev.filmsearch.domain.Interactor
import com.pochitaev.remote_module.TmdbApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
//Передаем контекст для SharedPreferences через конструктор
class DomainModule(val context: Context) {
    //Нам нужно контекст как-то провайдить, поэтому создаем такой метод
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    //Создаем экземпляр SharedPreferences
    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) = Interactor(repo = repository, retrofitService = tmdbApi, preferences = preferenceProvider)
}