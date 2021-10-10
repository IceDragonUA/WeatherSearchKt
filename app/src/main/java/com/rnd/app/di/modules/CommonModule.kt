package com.rnd.app.di.modules

import com.rnd.data.mapper.RemoteEntityToDomainMapper
import org.koin.dsl.module

val commonModule = module {
    single { RemoteEntityToDomainMapper() }
}