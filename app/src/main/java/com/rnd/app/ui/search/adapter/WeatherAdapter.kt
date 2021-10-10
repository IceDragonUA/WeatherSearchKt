package com.rnd.app.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rnd.app.databinding.ViewItemBinding
import com.rnd.domain.model.SearchData
import kotlin.properties.Delegates


/**
 * @author Vladyslav Havrylenko
 * @since 03.10.2020
 */
class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    var items: MutableList<SearchData> by Delegates.observable(mutableListOf()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder =
        WeatherViewHolder(ViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int): SearchData = items[position]

    override fun getItemCount(): Int = items.count()

    inner class WeatherViewHolder(private val itemBinding: ViewItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: SearchData) {
            itemBinding.apply {
                tvTitle.text = item.id.toString()
            }
        }
    }
}