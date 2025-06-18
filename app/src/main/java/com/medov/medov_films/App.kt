package com.medov.medov_films

import android.app.Application
import com.medov.medov_films.di.AppComponent
import com.medov.medov_films.di.modules.DatabaseModule
import com.medov.medov_films.di.modules.DomainModule
import com.medov.medov_films.di.modules.RemoteModule

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}