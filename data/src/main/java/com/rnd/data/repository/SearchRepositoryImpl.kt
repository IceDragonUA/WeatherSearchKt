package com.rnd.data.repository

import com.rnd.data.common.RepositoryBaseImpl
import com.rnd.data.datasource.local.dao.SearchResultDao
import com.rnd.data.datasource.remote.api.SearchResultApi
import com.rnd.data.mapper.DatabaseSearchMapper
import com.rnd.data.mapper.NetworkSearchMapper
import com.rnd.domain.core.ResultModel
import com.rnd.domain.model.SearchResult
import com.rnd.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class SearchRepositoryImpl(
    private val api: SearchResultApi,
    private val dao: SearchResultDao,
    private val networkMapper: NetworkSearchMapper,
    private val databaseMapper: DatabaseSearchMapper
) : RepositoryBaseImpl(), SearchRepository {

    override fun searchData(q: String): Flow<ResultModel<List<SearchResult>>> {
        return flow {
            emit(ResultModel.success(databaseMapper.mapFrom(dao.getList())))
            emit(ResultModel.loading())
            val result = getResponse({ api.search(q) }, networkMapper)
            emitCache(result)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    private suspend fun emitCache(result: ResultModel<List<SearchResult>>) {
        if (result.status == ResultModel.Status.SUCCESS) {
            result.data?.let { it ->
                dao.deleteAll()
                dao.insertAll(databaseMapper.mapTo(it))
            }
        }
    }
}
