package com.liaoye.weatherapp.domain


import android.util.Log
import com.liaoye.weatherapp.data.WeatherDataResult
import com.liaoye.weatherapp.data.WeatherInfo


/**
 * Created by xiaoming on 2017/8/23.
 */

class WeatherDataMapper {
    fun convertFromDataModel(weatherDataResult: WeatherDataResult): WeahterList{
        return WeahterList(convertForecastListToDomain(weatherDataResult.result.data.weather))
    }

    private fun convertForecastListToDomain(list: List<WeatherInfo>): List<Weather> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(weatherInfo: WeatherInfo): Weather{
        Log.d(javaClass.simpleName, weatherInfo.date)
        return Weather(weatherInfo.date,weatherInfo.info,weatherInfo.week,weatherInfo.nongli)
    }
}
