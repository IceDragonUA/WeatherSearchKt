package com.rnd.domain.interactor

import com.rnd.domain.core.ResultModel
import com.rnd.domain.model.SearchResult
import com.rnd.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchInteractor(private val searchRepository: SearchRepository) {

    fun searchData(q: String): Flow<ResultModel<List<SearchResult>>> {
        return searchRepository.searchData(q)
    }
}
