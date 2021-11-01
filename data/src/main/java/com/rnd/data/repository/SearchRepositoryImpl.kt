package com.rnd.data.repository

import com.rnd.data.common.RepositoryBaseImpl
import com.rnd.data.datasource.api.ApiEndpoint
import com.rnd.data.mapper.SearchMapper
import com.rnd.domain.core.ResultModel
import com.rnd.domain.model.SearchResult
import com.rnd.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class SearchRepositoryImpl(
    private val api: ApiEndpoint,
    private val mapper: SearchMapper
) : RepositoryBaseImpl(), SearchRepository {

    override fun searchData(q: String): Flow<ResultModel<List<SearchResult>>> {
        return flow {
            emit(ResultModel.loading())
            val result = getResponse({ api.search(q) }, mapper)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}
