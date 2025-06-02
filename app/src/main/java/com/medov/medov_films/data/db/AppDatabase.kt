package com.medov.medov_films.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.medov.medov_films.data.Entity.Film
import com.medov.medov_films.data.dao.FilmDao

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}