package com.rnd.app.ui.search

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.rnd.app.R
import com.rnd.app.common.base.BaseFragmentNavigationCommander
import com.rnd.app.common.base.BaseFragmentNavigator
import com.rnd.app.databinding.FragmentSearchBinding
import com.rnd.app.ui.main.toolbar.MainActivityToolbarWrapper
import com.rnd.app.ui.main.toolbar.SearchViewListener
import com.rnd.app.viewBinding.fragment.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment:
    BaseFragmentNavigator<BaseFragmentNavigationCommander, MainActivityToolbarWrapper>(),
    SearchViewListener {

    override fun getLayoutRes() = R.layout.fragment_search

    private val bindingView by viewBinding(FragmentSearchBinding::bind)

    private val viewModel: SearchViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarWrapper {
            hideAll()
            isToolbarTransparent(false)
            showSearchView()
            setSearchViewListener(this@SearchFragment)
        }
    }

    override fun subscribeToLivesData() {
        viewModel.items.observe(viewLifecycleOwner, Observer {

        })
    }

    override fun searchQuery(text: String) {
        viewModel.search(text)
    }

    override fun searchClearBtnClicked() {

    }
}