package com.rnd.app.ui.search

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rnd.domain.core.Failure
import com.rnd.domain.core.Success
import com.rnd.domain.interactor.SearchInteractor
import com.rnd.domain.model.SearchResult
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import timber.log.Timber

class SearchViewModel : ViewModel(), LifecycleObserver, KoinComponent {

    private val searchUseCase: SearchInteractor by inject()

    val items = MutableLiveData<List<SearchResult>>()

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
        val searchResult = scope.async {
            searchUseCase.searchData(query)
        }

        var list = listOf<SearchResult>()
        when (val result = searchResult.await()) {
            is Success -> {
                result.payload?.let { data ->
                    list = data
                }
                items.postValue(list)
            }
            is Failure -> {
                Timber.e("code: ${result.error.code}, message: ${result.error.message}")
            }
        }
    }
}
