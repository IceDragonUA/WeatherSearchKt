package com.rnd.app.ui.main

import com.rnd.app.R
import com.rnd.app.common.base.BaseFragmentNavigationCommander
import com.rnd.app.common.base.BaseNavigationActivity

abstract class MainNavigationActivity: BaseNavigationActivity(), BaseFragmentNavigationCommander {

    override fun openSearchFragment() = openFragment(R.id.searchFragment)

}