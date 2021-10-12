package com.rnd.data.mapper

import com.rnd.data.common.DataMapper
import com.rnd.data.datasource.model.RemoteSearchResultResponse
import com.rnd.domain.model.SearchResult

class RemoteEntityToDomainMapper {

    companion object {
        const val TEMP_VALUE = "°C"
        const val LATITUDE_VALUE = "Latitude: "
        const val LONGITUDE_VALUE = "Longitude: "
    }

    fun mapSearchDataResponse(): DataMapper<RemoteSearchResultResponse, List<SearchResult>?> {
        return object : DataMapper<RemoteSearchResultResponse, List<SearchResult>?> {
            override fun map(input: RemoteSearchResultResponse): List<SearchResult> {
                val items = mutableListOf<SearchResult>()
                input.list.map {
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
    }
}
