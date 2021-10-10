package com.rnd.domain.usecase

import com.rnd.domain.core.ErrorModel
import com.rnd.domain.core.Result
import com.rnd.domain.model.SearchData
import com.rnd.domain.repository.SearchRepository

class SearchUseCase(private val searchRepository: SearchRepository) {

    fun searchData(q: String): Result<List<SearchData>?, ErrorModel> {
        return searchRepository.searchData(q)
    }
}
