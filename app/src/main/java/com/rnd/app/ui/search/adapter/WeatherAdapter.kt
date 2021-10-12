package com.rnd.app.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rnd.app.databinding.ViewListItemBinding
import com.rnd.app.extension.defIfNull
import com.rnd.app.extension.loadFromUrl
import com.rnd.domain.model.SearchResult
import kotlin.properties.Delegates


/**
 * @author Vladyslav Havrylenko
 * @since 03.10.2020
 */
class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    var items: List<SearchResult> by Delegates.observable(listOf()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder =
        WeatherViewHolder(ViewListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int): SearchResult = items[position]

    override fun getItemCount(): Int = items.count()

    inner class WeatherViewHolder(private val itemBinding: ViewListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: SearchResult) {
            itemBinding.apply {
                tvName.text = item.name
                tvTemp.text = item.temp
                tvCountry.text = item.country
                tvShortDescription.text = item.shortDescription
                tvLongDescription.text = item.longDescription
                tvLatitude.text = item.latitude
                tvLongitude.text = item.longitude
                ivIcon.loadFromUrl(item.icon.defIfNull())
            }
        }
    }
}