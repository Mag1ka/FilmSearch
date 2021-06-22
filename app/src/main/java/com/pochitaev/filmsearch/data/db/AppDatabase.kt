package com.pochitaev.filmsearch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pochitaev.filmsearch.data.dao.FilmDao
import com.pochitaev.filmsearch.data.entity.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}