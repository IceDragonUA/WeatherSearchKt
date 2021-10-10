package com.rnd.data.repository

import com.rnd.data.common.safeExecute
import com.rnd.data.datasource.remote.api.ApiEndpoint
import com.rnd.data.mapper.RemoteEntityToDomainMapper
import com.rnd.domain.core.ErrorModel
import com.rnd.domain.core.Result
import com.rnd.domain.model.SearchData
import com.rnd.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val api: ApiEndpoint,
    private val mapper: RemoteEntityToDomainMapper
) : SearchRepository {

    override fun searchData(q: String): Result<SearchData?, ErrorModel> {
        return api.search(q).safeExecute(mapper.mapSearchDataResponse())
    }
}
