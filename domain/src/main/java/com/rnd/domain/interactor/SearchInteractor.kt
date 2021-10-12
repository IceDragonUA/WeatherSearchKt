package com.rnd.domain.interactor

import com.rnd.domain.core.ErrorModel
import com.rnd.domain.core.Result
import com.rnd.domain.model.SearchResult
import com.rnd.domain.repository.SearchRepository

class SearchInteractor(private val searchRepository: SearchRepository) {

    fun searchData(q: String): Result<List<SearchResult>?, ErrorModel> {
        return searchRepository.searchData(q)
    }
}
