package com.rnd.app.common.base

import com.rnd.app.ui.main.toolbar.SearchViewListener

abstract class BaseToolbarWrapperFragment<out TW : BaseToolbarWrapper> : BaseCommanderFragment() {

    fun toolbarWrapper(toolbarWrapper: TW.() -> Unit) {
        // as? - cast to type, when catch error, return null
        (activity as? TW)?.let { toolbarWrapper.invoke(it) }
    }

}

interface BaseToolbarWrapper {
    fun hideAll()
    fun showSearchView()
    fun setSearchViewListener(searchListener: SearchViewListener)
}