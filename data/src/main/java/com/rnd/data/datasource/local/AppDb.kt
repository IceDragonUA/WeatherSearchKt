package com.rnd.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rnd.data.datasource.local.dao.SearchResultDao
import com.rnd.data.datasource.local.model.LocalSearchResultResponse

@Database(
    entities = [
        LocalSearchResultResponse::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {
    abstract fun weatherDao(): SearchResultDao
}
