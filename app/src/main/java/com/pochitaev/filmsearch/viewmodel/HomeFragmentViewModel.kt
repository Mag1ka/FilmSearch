package com.pochitaev.filmsearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pochitaev.filmsearch.App
import com.pochitaev.filmsearch.domain.Film
import com.pochitaev.filmsearch.domain.Interactor


class HomeFragmentViewModel : ViewModel() {
    val filmsListLiveData: MutableLiveData<List<Film>> = MutableLiveData()

    //Инициализируем интерактор
    private var interactor: Interactor = App.instance.interactor

    init {
        interactor.getFilmsFromApi(1, object : ApiCallback {
            override fun onSuccess(films: List<Film>) {
                filmsListLiveData.postValue(films)

            }

            override fun onFailure() {
            }
        })
    }

    interface ApiCallback {
        fun onSuccess(films: List<Film>)
        fun onFailure()
    }
}