package com.rnd.app.ui.main.toolbar

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.rnd.app.R
import com.rnd.app.extension.gone
import com.rnd.app.extension.showSoftKeyboard
import com.rnd.app.extension.visible
import kotlinx.android.synthetic.main.view_main_toolbar.view.*

class MainActivityToolbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_main_toolbar, this)
    }

    fun setSearchViewListener(searchListener: SearchViewListener) {
        viewSearch.searchListener = searchListener
    }

    fun showSearchContainer() {
        viewSearch.visible()
        viewSearch.requestFocus()
        viewSearch.showSoftKeyboard(true)
    }

    fun hideAll() {
        viewSearch.gone()
    }

    fun isToolbarTransparent(isTransparent: Boolean) {
        if (isTransparent) {
            container.setBackgroundColor(Color.TRANSPARENT)
        } else {
            container.setBackgroundColor(ContextCompat.getColor(context, R.color.color_grey))
        }
    }
}
