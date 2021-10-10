package com.rnd.app.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rnd.app.common.base.BaseViewModel
import com.rnd.app.extension.Event
import com.rnd.domain.core.Failure
import com.rnd.domain.core.Success
import com.rnd.domain.model.SearchData
import com.rnd.domain.usecase.SearchUseCase
import kotlinx.coroutines.*
import org.koin.core.inject
import timber.log.Timber

class SearchViewModel : BaseViewModel() {

    private val searchUseCase: SearchUseCase by inject()

    val items = MutableLiveData<MutableList<SearchData>>()

    fun search(query: String) {
        synchronized(this) {
            runBlocking {
                viewModelScope.launch(Dispatchers.IO) {
                    loadSearchPage(this, query)
                }
            }
        }
    }

    private suspend fun loadSearchPage(
        scope: CoroutineScope,
        query: String
    ) {
        isLoading.postValue(Event(true))

        val searchResult = scope.async {
            searchUseCase.searchData(query)
        }

        when (val searchResult = searchResult.await()) {
            is Success -> {
                val list = mutableListOf<SearchData>()
                searchResult.payload?.let { data ->
                    list.addAll(data)
                }
                items.postValue(list)

                isLoading.postValue(Event(false))
            }
            is Failure -> {
                items.postValue(mutableListOf())
                Timber.e("code: ${searchResult.error.code}, message: ${searchResult.error.message}")
            }
        }
    }
}
