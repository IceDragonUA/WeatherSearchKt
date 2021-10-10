package com.rnd.app.common.base

abstract class BaseCommanderFragment: BaseFragment() {

    inline fun <reified Commander> commander(function: Commander.() -> Unit) {
        context?.let {
            if (it is Commander) function(it)
        }
    }

    inline fun <reified Commander> commander() =
        context as? Commander

    inline fun <reified Commander, T> commander(function: Commander.() -> T?): T? =
        context?.let {
            if (it is Commander) function(it) else null
        }
}
