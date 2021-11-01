package com.rnd.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rnd.data.datasource.local.dao.WeatherDao
import com.rnd.data.datasource.local.model.WeatherInfo

@Database(
    entities = [
        WeatherInfo::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
