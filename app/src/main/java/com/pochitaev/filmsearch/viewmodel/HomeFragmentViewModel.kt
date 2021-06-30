package com.pochitaev.filmsearch.viewmodel

import androidx.lifecycle.ViewModel
import com.pochitaev.filmsearch.App
import com.pochitaev.filmsearch.data.entity.Film
import com.pochitaev.filmsearch.domain.Interactor
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class HomeFragmentViewModel : ViewModel() {
    val showProgressBar: Channel<Boolean>

    //Инициализируем интерактор
    @Inject

    lateinit var interactor: Interactor
    val filmsListData: Flow<List<Film>>

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarState
        filmsListData = interactor.getFilmsFromDB()
        getFilms()
    }

    fun getFilms() {
        interactor.getFilmsFromApi(1)
    }

    interface ApiCallback {
        fun onSuccess()
        fun onFailure()
    }
}
