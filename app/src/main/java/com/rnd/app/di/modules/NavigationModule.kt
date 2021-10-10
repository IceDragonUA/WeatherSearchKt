package com.rnd.app.di.modules

import com.rnd.app.ui.main.MainActivity
import com.rnd.app.ui.main.MainNavigationActivity
import org.koin.core.qualifier.named
import org.koin.dsl.module

val navigationModule = module {
    scope(named<MainActivity>()) {
        scoped { (navigationActivity: MainNavigationActivity?) -> navigationActivity }
    }
}