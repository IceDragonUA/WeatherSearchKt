package com.rnd.app.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rnd.app.databinding.ViewItemBinding
import com.rnd.app.extension.defIfNull
import com.rnd.app.extension.loadFromUrl
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
                tvName.text = item.name.toString()
                tvTemp.text = StringBuilder().apply {
                    append(item.temp?.defIfNull()?.minus(272.15)?.toInt())
                    append("°C")
                }.toString()
                tvCountry.text = item.country.toString()
                tvShortDescription.text =
                    StringBuilder().apply {
                        append(item.shortDescription.toString())
                        append(",")
                    }.toString()
                tvLongDescription.text = item.longDescription.toString()
                tvLatitude.text = StringBuilder().apply {
                    append("Latitude: ")
                    append(item.latitude)
                }.toString()
                tvLongitude.text = StringBuilder().apply {
                    append("Longitude: ")
                    append(item.longitude)
                }.toString()
                ivIcon.loadFromUrl(item.icon.defIfNull())
            }
        }
    }
}