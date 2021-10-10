package com.rnd.app.ui.main.toolbar

import android.content.Context
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import android.widget.FrameLayout
import android.widget.TextView.OnEditorActionListener
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.rnd.app.R
import kotlinx.android.synthetic.main.view_search.view.*


interface SearchViewListener {
    fun searchQuery(text: String) {}
    fun searchClearBtnClicked() {}
}

class SearchView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_search, this).apply {
            layoutParams = RecyclerView.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
        }
        initClicks()
    }

    var searchListener: SearchViewListener? = null

    private fun initClicks() {
        ivClear.setOnClickListener {
            etSearch.setText("")
            searchListener?.searchClearBtnClicked()
        }
        ivSearch.setOnClickListener {
            etSearch.text?.toString()?.let {
                searchListener?.searchQuery(it)
            }
        }

        etSearch.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                etSearch.text?.toString()?.let {
                    searchListener?.searchQuery(it)
                }
                return@OnEditorActionListener true
            }
            false
        })
    }
}
