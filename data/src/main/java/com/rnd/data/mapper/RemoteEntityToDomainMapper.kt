package com.rnd.data.mapper

import com.rnd.data.common.DataMapper
import com.rnd.data.datasource.remote.model.RemoteSearchDataResponse
import com.rnd.domain.model.SearchData

class RemoteEntityToDomainMapper {

    fun mapSearchDataResponse(): DataMapper<RemoteSearchDataResponse, SearchData?> {
        return object : DataMapper<RemoteSearchDataResponse, SearchData?> {
            override fun map(input: RemoteSearchDataResponse): SearchData {
                return SearchData(
                    input.id
                )
            }
        }
    }
}
