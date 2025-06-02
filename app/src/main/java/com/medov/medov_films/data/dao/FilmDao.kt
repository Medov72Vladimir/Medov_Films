package com.medov.medov_films.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.medov.medov_films.data.Entity.Film

//Помечаем, что это не просто интерфейс а Dao объект
@Dao
interface FilmDao {
    //Запрос на всю таблицу
    @Query("SELECT * FROM cached_films")
    fun getCachedFilms(): List<Film>

    //Кладем списком в БД, в случае конфликта, перезаписываем
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Film>)
}