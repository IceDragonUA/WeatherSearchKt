package com.rnd.domain.repository

import com.rnd.domain.core.ResultModel
import com.rnd.domain.model.SearchResult
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun searchData(q: String): Flow<ResultModel<List<SearchResult>>>

}
