package com.rnd.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rnd.data.datasource.local.model.LocalSearchResultResponse

@Dao
interface SearchResultDao {

    @Query("SELECT * FROM ${LocalSearchResultResponse.DB_TABLE_NAME}")
    suspend fun getList(): List<LocalSearchResultResponse>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(weatherInfoList: List<LocalSearchResultResponse>)

    @Query("DELETE FROM ${LocalSearchResultResponse.DB_TABLE_NAME}")
    fun deleteAll()
}
