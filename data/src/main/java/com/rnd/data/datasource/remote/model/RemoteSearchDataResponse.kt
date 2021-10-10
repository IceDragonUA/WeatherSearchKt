package com.rnd.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteSearchDataResponse(
    @SerializedName("list") val list: List<RemoteListItemResponse>?
)

data class RemoteListItemResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("coord") val coord: RemoteCoordResponse?,
    @SerializedName("main") val main: RemoteMainResponse?,
    @SerializedName("sys") val sys: RemoteCountryResponse?,
    @SerializedName("weather") val weather: List<RemoteWeatherResponse>?,
)

data class RemoteCoordResponse(
    @SerializedName("lat") val lat: Float?,
    @SerializedName("lon") val lon: Float?,
)

data class RemoteMainResponse(
    @SerializedName("temp") val temp: Float?,
)

data class RemoteCountryResponse(
    @SerializedName("country") val country: String?
)

data class RemoteWeatherResponse(
    @SerializedName("main") val main: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("icon") val icon: String?
)