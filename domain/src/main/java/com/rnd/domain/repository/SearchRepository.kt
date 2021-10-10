package com.rnd.domain.repository

import com.rnd.domain.core.ErrorModel
import com.rnd.domain.core.Result
import com.rnd.domain.model.SearchData

interface SearchRepository {

    fun searchData(q: String): Result<SearchData?, ErrorModel>

}
