package com.pochitaev.filmsearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pochitaev.filmsearch.App
import com.pochitaev.filmsearch.Film
import com.pochitaev.filmsearch.domain.Interactor


class HomeFragmentViewModel : ViewModel() {
    val filmsListLiveData:  MutableLiveData<List<Film>> = MutableLiveData()
    //Инициализируем интерактор
    private var interactor: Interactor = App.instance.interactor

    init {
        val films = interactor.getFilmsDB()
        filmsListLiveData.postValue(films)
    }
}