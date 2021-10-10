package com.rnd.app.extension

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager

fun View.removeParentFirst(): View {
    this.parent?.let {
        (it as ViewGroup).removeView(this)
    }
    return this
}

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.visible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.showSoftKeyboard(show: Boolean) {
    val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    if (show) imm?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    else imm?.hideSoftInputFromWindow(this.windowToken, 0)
}

fun View.padding(
    left: Int = paddingLeft,
    top: Int = paddingTop,
    right: Int = paddingRight,
    bottom: Int = paddingBottom
) {
    setPadding(left, top, right, bottom)
}