package com.rnd.app.common.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.rnd.app.extension.event
import org.koin.core.KoinComponent

open class BaseViewModel : ViewModel(), LifecycleObserver, KoinComponent {
    val isLoading = event<Boolean>()
}
