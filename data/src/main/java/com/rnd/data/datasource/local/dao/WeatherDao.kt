package com.rnd.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rnd.data.datasource.local.model.WeatherInfo

@Dao
interface WeatherDao {

    @Query("SELECT * FROM ${WeatherInfo.DB_TABLE_NAME}")
    suspend fun getList(): List<WeatherInfo>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(weatherInfoList: List<WeatherInfo>)

    @Query("DELETE FROM ${WeatherInfo.DB_TABLE_NAME}")
    fun deleteAll()
}
