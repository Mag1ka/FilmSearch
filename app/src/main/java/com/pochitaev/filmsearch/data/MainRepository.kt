package com.pochitaev.filmsearch.data

import com.pochitaev.filmsearch.data.dao.FilmDao
import com.pochitaev.filmsearch.data.entity.Film
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

        fun putToDb(films: List<Film>) {
            //Запросы в БД должны быть в отдельном потоке
            Executors.newSingleThreadExecutor().execute {
                filmDao.insertAll(films)
            }
        }

    fun getAllFromDB(): Flow<List<Film>> = filmDao.getCachedFilms()
    }