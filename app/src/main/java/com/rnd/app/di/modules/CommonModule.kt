package com.rnd.app.di.modules

import com.rnd.data.mapper.SearchMapper
import org.koin.dsl.module

val commonModule = module {
    single { SearchMapper() }
}