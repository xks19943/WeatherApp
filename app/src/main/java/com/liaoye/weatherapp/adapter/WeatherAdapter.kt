package com.liaoye.weatherapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.liaoye.weatherapp.R
import com.liaoye.weatherapp.domain.Weather
import com.liaoye.weatherapp.views.DaysWeatherView
import org.jetbrains.anko.find

/**
 * Created by xiaoming on 2017/8/23.
 */
class WeatherAdapter(val weatherList: List<Weather>) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather,parent,false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        //这表示所有我们在括号中编写的代码都是作为对象（第一个参数）的一个扩展函数，
        // 我们可以就像作为this一样使用所有它的public方法和属性
       holder.bindWeatherData(weatherList[position])
    }

    override fun getItemCount() = weatherList.size


    class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val tv_date: TextView
        private val tv_week: TextView
        private val tv_moon: TextView
        private val ll_daysOfWeather:LinearLayout
        private val mContext:Context

        init {
            mContext = view.context
            tv_date = view.find(R.id.tv_date)
            tv_week = view.find(R.id.tv_week)
            tv_moon = view.find(R.id.tv_moon)
            ll_daysOfWeather = view.findViewById(R.id.ll_daysOfWeather) as LinearLayout
        }

        fun bindWeatherData(weather: Weather){
            with(weather){
                tv_date.text = date
                tv_week.text = "星期$week"
                tv_moon.text = nongli
                val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.toFloat())
                if(info.dawn!=null){
                    val daysWeatherView1 = DaysWeatherView(mContext,null)
                    daysWeatherView1.setDaysOfWeaher(info.dawn,0)
                    ll_daysOfWeather.addView(daysWeatherView1,params)
                }
                if(info.day!=null){
                    val daysWeatherView2 = DaysWeatherView(mContext,null)
                    daysWeatherView2.setDaysOfWeaher(info.day,1)
                    ll_daysOfWeather.addView(daysWeatherView2,params)
                }
                if(info.night!=null){
                    val daysWeatherView2 = DaysWeatherView(mContext,null)
                    daysWeatherView2.setDaysOfWeaher(info.night,2)
                    ll_daysOfWeather.addView(daysWeatherView2,params)
                }
            }
        }


    }



}