package com.medov.medov_films.domain

import com.medov.medov_films.data.MainRepository

class Interactor(private val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}