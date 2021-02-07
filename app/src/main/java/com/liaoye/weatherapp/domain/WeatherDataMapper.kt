package com.liaoye.weatherapp.domain


import android.util.Log
import com.liaoye.weatherapp.data.Future
import com.liaoye.weatherapp.data.WeatherDataResult


/**
 * Created by xiaoming on 2017/8/23.
 */

class WeatherDataMapper {
    fun convertFromDataModel(weatherDataResult: WeatherDataResult): WeatherList {
        return WeatherList(convertForecastListToDomain(weatherDataResult.result.future))
    }

    private fun convertForecastListToDomain(list: List<Future>): List<Weather> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(future: Future): Weather {
        Log.d(javaClass.simpleName, future.date)
        return Weather(future.date, future.temperature, future.weather, future.direct)
    }
}
