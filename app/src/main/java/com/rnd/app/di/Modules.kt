package com.rnd.app.di

import com.rnd.app.di.modules.*

val koinModules = listOf(
    navigationModule,
    interactorModule,
    networkModule,
    repositoryModule,
    commonModule,
    appModule
)