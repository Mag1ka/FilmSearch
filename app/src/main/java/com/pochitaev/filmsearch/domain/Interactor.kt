package com.pochitaev.filmsearch.domain

import com.pochitaev.filmsearch.Film
import com.pochitaev.filmsearch.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}