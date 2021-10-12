package com.rnd.app.di

import com.rnd.app.di.modules.*

val koinModules = listOf(
    appModule,
    interactorModule,
    repositoryModule,
    commonModule,
    networkModule
)