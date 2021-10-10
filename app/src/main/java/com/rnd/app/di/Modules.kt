package com.rnd.app.di

import com.rnd.app.di.modules.*

val koinModules = listOf(
    navigationModule,
    useCaseModule,
    networkModule,
    dataModule,
    commonModule,
    appModule
)