package com.rnd.data.mapper

import com.rnd.data.common.DataMapper
import com.rnd.data.datasource.remote.model.RemoteSearchDataResponse
import com.rnd.domain.model.SearchData

class RemoteEntityToDomainMapper {

    fun mapSearchDataResponse(): DataMapper<RemoteSearchDataResponse, List<SearchData>?> {
        return object : DataMapper<RemoteSearchDataResponse, List<SearchData>?> {
            override fun map(input: RemoteSearchDataResponse): List<SearchData> {
                val items = mutableListOf<SearchData>()
                input.list?.map {
                    items.add(
                        SearchData(
                            id = it.id,
                            name = it.name,
                            temp = it.main?.temp,
                            country = it.sys?.country,
                            shortDescription = it.weather?.first()?.main,
                            longDescription = it.weather?.first()?.description,
                            latitude = it.coord?.lat,
                            longitude = it.coord?.lon,
                            icon = it.weather?.first()?.icon
                        )
                    )
                }
                return items
            }
        }
    }
}
