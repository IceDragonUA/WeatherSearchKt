package com.rnd.app.ui.search.view

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rnd.app.ui.search.adapter.WeatherAdapter


/**
 * @author Vladyslav Havrylenko
 * @since 27.01.2021
 */
class WeatherGridView : RecyclerView {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        adapter = WeatherAdapter()
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        setHasFixedSize(true)
        itemAnimator = null
    }

    override fun getAdapter(): WeatherAdapter? =
        super.getAdapter() as? WeatherAdapter

}