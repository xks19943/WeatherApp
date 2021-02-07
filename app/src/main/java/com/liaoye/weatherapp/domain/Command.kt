package com.liaoye.weatherapp.domain


/**
 * Created by xiaoming on 2017/8/23.
 */
abstract interface Command<out T>{
    abstract fun execute(): T
}

data class WeatherList(val weather: List<Weather>)

data class Weather(
        val date: String,
        val temperature: String,
        val weather: String,
        val direct: String
)

