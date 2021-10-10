package com.rnd.data.mapper

import com.rnd.data.common.DataMapper
import com.rnd.data.datasource.remote.model.RemoteSearchDataResponse
import com.rnd.domain.model.Country
import com.rnd.domain.model.Main
import com.rnd.domain.model.SearchData
import com.rnd.domain.model.Weather

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
                            main = Main(
                                temp = it.main?.temp
                            ),
                            sys = Country(
                                country = it.sys?.country
                            ),
                            weather = Weather(
                                main = it.weather?.main,
                                description = it.weather?.description,
                                icon = it.weather?.icon
                            )
                        )
                    )
                }
                return items
            }
        }
    }
}
