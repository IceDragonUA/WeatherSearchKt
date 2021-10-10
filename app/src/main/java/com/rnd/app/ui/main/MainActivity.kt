package com.rnd.app.ui.main

import android.os.Bundle
import com.rnd.app.R
import com.rnd.app.common.base.BaseToolbarWrapper
import com.rnd.app.databinding.ActivityMainBinding
import com.rnd.app.ui.main.toolbar.SearchViewListener
import com.rnd.app.viewBinding.activity.viewBinding

class MainActivity : MainNavigationActivity(), BaseToolbarWrapper {

    override fun getNavControllerLayoutRes() = R.id.navHostFragment

    private val bindingView by viewBinding(ActivityMainBinding::bind, R.id.root_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun hideAll() = bindingView.toolbar.hideAll()

    override fun showSearchView() = bindingView.toolbar.showSearchContainer()

    override fun setSearchViewListener(searchListener: SearchViewListener) {
        bindingView.toolbar.setSearchViewListener(searchListener)
    }
}
