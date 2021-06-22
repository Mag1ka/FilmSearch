package com.pochitaev.filmsearch.utils

import com.pochitaev.filmsearch.data.entity.TmdbFilm
import com.pochitaev.filmsearch.data.entity.Film


object Converter {
    fun convertApiListToDTOList(list: List<TmdbFilm>?): List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(Film(
                title = it.title,
                poster = it.posterPath,
                description = it.overview,
                rating = it.voteAverage,
                isInFavorites = false
            ))
        }
        return result
    }
}