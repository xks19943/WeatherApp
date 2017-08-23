package com.liaoye.weatherapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.liaoye.weatherapp.domain.Weather

/**
 * Created by xiaoming on 2017/8/23.
 */
class WeatherAdapter(val items: List<Weather>) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.textView.text = items[position].date
    }

    override fun getItemCount() = items.size


    class WeatherViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}