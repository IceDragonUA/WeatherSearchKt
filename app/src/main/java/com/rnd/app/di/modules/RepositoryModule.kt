package com.rnd.app.di.modules

import com.rnd.data.repository.SearchRepositoryImpl
import com.rnd.domain.repository.SearchRepository
import org.koin.dsl.module

/**
 * @author Vladyslav Havrylenko
 * @since 23.12.2020
 */

val repositoryModule = module {
    single<SearchRepository> {
        SearchRepositoryImpl(
            api = get(),
            dao = get(),
            networkMapper = get(),
            databaseMapper = get()
        )
    }
}