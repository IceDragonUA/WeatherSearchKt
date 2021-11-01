package com.rnd.data.mapper

import com.rnd.data.common.RemoteEntityToDomainMapper
import com.rnd.data.datasource.remote.model.RemoteSearchResultResponse
import com.rnd.domain.model.SearchResult

class SearchMapper: RemoteEntityToDomainMapper<RemoteSearchResultResponse, List<SearchResult>>() {

    companion object {
        const val TEMP_VALUE = "°C"
        const val LATITUDE_VALUE = "Latitude: "
        const val LONGITUDE_VALUE = "Longitude: "
    }

    override fun map(input: RemoteSearchResultResponse?): List<SearchResult> {
        val items = mutableListOf<SearchResult>()
        input?.list?.map {
            items.add(
                SearchResult(
                    id = it.id.toString(),
                    name = it.name,
                    temp = (it.main.temp - 272.15).toInt().toString() + TEMP_VALUE,
                    country = it.sys.country,
                    shortDescription = it.weather.first().main + ",",
                    longDescription = it.weather.first().description,
                    latitude = LATITUDE_VALUE + it.coord.lat.toString(),
                    longitude = LONGITUDE_VALUE + it.coord.lon.toString(),
                    icon = it.weather.first().icon
                )
            )
        }
        return items
    }
}
