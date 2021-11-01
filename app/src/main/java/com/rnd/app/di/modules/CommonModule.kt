package com.rnd.app.di.modules

import com.rnd.data.mapper.DatabaseSearchMapper
import com.rnd.data.mapper.NetworkSearchMapper
import org.koin.dsl.module

val commonModule = module {
    single { NetworkSearchMapper() }
    single { DatabaseSearchMapper() }
}