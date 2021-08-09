package com.pochitaev.filmsearch.viewmodel

import androidx.lifecycle.ViewModel
import com.pochitaev.filmsearch.App
import com.pochitaev.filmsearch.data.entity.Film
import com.pochitaev.filmsearch.domain.Interactor
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject


class HomeFragmentViewModel : ViewModel() {
    val showProgressBar: BehaviorSubject<Boolean>

    //Инициализируем интерактор
    @Inject

    lateinit var interactor: Interactor
    val filmsListData: Observable<List<Film>>

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarState
        filmsListData = interactor.getFilmsFromDB()
        getFilms()
    }

    fun getFilms() {
        interactor.getFilmsFromApi(1)
    }
    fun getSearchResult(search: String) = interactor.getSearchResultFromApi(search)

    interface ApiCallback {
        fun onSuccess()
        fun onFailure()
    }
}
