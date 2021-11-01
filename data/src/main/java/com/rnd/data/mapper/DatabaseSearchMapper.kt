package com.rnd.data.mapper

import com.rnd.data.common.DatabaseEntityToFromDomainMapper
import com.rnd.data.datasource.local.model.LocalSearchResultResponse
import com.rnd.domain.model.SearchResult

class DatabaseSearchMapper: DatabaseEntityToFromDomainMapper<List<SearchResult>, List<LocalSearchResultResponse>>() {

    override fun mapTo(input: List<SearchResult>?): List<LocalSearchResultResponse> {
        val items = mutableListOf<LocalSearchResultResponse>()
        input?.map {
            items.add(
                LocalSearchResultResponse(
                    id = it.id,
                    name = it.name,
                    temp = it.temp,
                    country = it.country,
                    shortDescription = it.shortDescription,
                    longDescription = it.longDescription,
                    latitude = it.latitude,
                    longitude = it.longitude,
                    icon = it.icon
                )
            )
        }
        return items
    }

    override fun mapFrom(input: List<LocalSearchResultResponse>?): List<SearchResult> {
        val items = mutableListOf<SearchResult>()
        input?.map {
            items.add(
                SearchResult(
                    id = it.id,
                    name = it.name,
                    temp = it.temp,
                    country = it.country,
                    shortDescription = it.shortDescription,
                    longDescription = it.longDescription,
                    latitude = it.latitude,
                    longitude = it.longitude,
                    icon = it.icon
                )
            )
        }
        return items
    }
}
