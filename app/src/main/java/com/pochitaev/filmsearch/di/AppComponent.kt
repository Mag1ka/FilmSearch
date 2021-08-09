package com.pochitaev.filmsearch.di

import com.pochitaev.filmsearch.di.modules.DatabaseModule
import com.pochitaev.filmsearch.di.modules.DomainModule
import com.pochitaev.filmsearch.viewmodel.HomeFragmentViewModel
import com.pochitaev.filmsearch.viewmodel.SettingsFragmentViewModel
import dagger.Component
import com.pochitaev.remote_module.RemoteProvider
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    dependencies = [RemoteProvider::class],
    modules = [
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась возможность внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    //метод для того, чтобы появилась возможность внедрять зависимости в SettingsFragmentViewModel
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}