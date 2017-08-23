package com.liaoye.weatherapp.domain

import com.liaoye.weatherapp.data.WeatherDetail


/**
 * Created by xiaoming on 2017/8/23.
 */
abstract interface Command<out T>{
    abstract fun execute(): T
}

data class WeahterList(val weather: List<Weather>)

data class Weather(
        val date: String,
        val info: WeatherDetail,
        val week: String,
        val nongli: String
)

