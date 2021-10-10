package com.rnd.app.di.modules

import com.rnd.app.common.base.HeaderInterceptor
import com.rnd.app.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { HeaderInterceptor() }
    viewModel { SearchViewModel() }
}
