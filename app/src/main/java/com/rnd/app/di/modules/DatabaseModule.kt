package com.rnd.app.di.modules

import android.app.Application
import androidx.room.Room
import com.rnd.data.datasource.local.AppDb
import com.rnd.data.datasource.local.dao.WeatherDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * @author Vladyslav Havrylenko
 * @since 01.11.2021
 */
val databaseModule = module {
    single { provideAppDb(androidApplication()) }
    single { provideWeatherDao(db = get()) }
}

private fun provideAppDb(app: Application): AppDb {
    return Room
        .databaseBuilder(app, AppDb::class.java, "app.db")
        .fallbackToDestructiveMigration()
        .build()
}

private fun provideWeatherDao(db: AppDb): WeatherDao = db.weatherDao()