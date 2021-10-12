package com.rnd.app.di.modules

import com.rnd.domain.interactor.SearchInteractor
import org.koin.dsl.module

val interactorModule = module {
    single { SearchInteractor(searchRepository = get()) }
}