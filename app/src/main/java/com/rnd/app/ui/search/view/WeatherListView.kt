package com.rnd.app.ui.search.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.rnd.app.R
import com.rnd.app.ui.search.adapter.WeatherAdapter
import com.rnd.domain.model.SearchResult
import kotlinx.android.synthetic.main.view_list.view.*


/**
 * @author Vladyslav Havrylenko
 * @since 27.01.2021
 */
class WeatherListView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_list, this)
        weatherList.adapter = WeatherAdapter()
        weatherList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        weatherList.setHasFixedSize(true)
        weatherList.itemAnimator = null
    }

    fun setItems(list: List<SearchResult>) {
        (weatherList.adapter as? WeatherAdapter)?.items = list
    }
}