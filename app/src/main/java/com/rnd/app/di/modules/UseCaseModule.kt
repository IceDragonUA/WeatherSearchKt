package com.rnd.app.di.modules

import com.rnd.domain.usecase.SearchUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { SearchUseCase(searchRepository = get()) }
}