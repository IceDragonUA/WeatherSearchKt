package com.rnd.data.datasource.local.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rnd.data.datasource.local.model.WeatherInfo.Companion.DB_TABLE_NAME
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = DB_TABLE_NAME)
data class WeatherInfo(
    @PrimaryKey
    @ColumnInfo(name = DB_FIELD_ID)
    val id: String,
    @ColumnInfo(name = DB_FIELD_NAME)
    val name: String,
    @ColumnInfo(name = DB_FIELD_TEMP)
    val temp: String,
    @ColumnInfo(name = DB_FIELD_COUNTRY)
    val country: String,
    @ColumnInfo(name = DB_FIELD_SHORT_DESCRIPTION)
    val shortDescription: String,
    @ColumnInfo(name = DB_FIELD_LONG_DESCRIPTION)
    val longDescription: String,
    @ColumnInfo(name = DB_FIELD_LATITUDE)
    val latitude: String,
    @ColumnInfo(name = DB_FIELD_LONGITUDE)
    val longitude: String,
    @ColumnInfo(name = DB_FIELD_ICON)
    val icon: String
) : Parcelable {
    companion object {
        const val DB_TABLE_NAME = "weather_info"
        const val DB_FIELD_ID = "id"
        const val DB_FIELD_NAME = "name"
        const val DB_FIELD_TEMP = "temp"
        const val DB_FIELD_COUNTRY = "country"
        const val DB_FIELD_SHORT_DESCRIPTION = "shortDescription"
        const val DB_FIELD_LONG_DESCRIPTION = "longDescription"
        const val DB_FIELD_LATITUDE = "latitude"
        const val DB_FIELD_LONGITUDE = "longitude"
        const val DB_FIELD_ICON = "icon"
    }
}
