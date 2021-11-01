package com.rnd.app.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rnd.domain.core.ResultModel
import com.rnd.domain.interactor.SearchInteractor
import com.rnd.domain.model.SearchResult
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class SearchViewModel : ViewModel(), KoinComponent {

    private val interactor: SearchInteractor by inject()

    private val _items = MutableLiveData<ResultModel<List<SearchResult>>>()
    val items = _items

    fun search(query: String) {
        viewModelScope.launch {
            interactor.searchData(query).collect {
                items.value = it
            }
        }
    }
}
