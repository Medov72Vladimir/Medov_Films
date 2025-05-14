package com.medov.medov_films.di

import com.medov.medov_films.di.modules.DatabaseModule
import com.medov.medov_films.di.modules.DomainModule
import com.medov.medov_films.di.modules.RemoteModule
import com.medov.medov_films.viewmodel.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась возможность внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
}