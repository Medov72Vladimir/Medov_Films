package com.medov.medov_films.di.modules

import com.medov.medov_films.data.MainRepository
import com.medov.medov_films.data.TmdbApi
import com.medov.medov_films.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}