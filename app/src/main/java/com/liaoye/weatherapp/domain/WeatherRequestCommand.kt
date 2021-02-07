package com.liaoye.weatherapp.domain

import com.liaoye.weatherapp.data.WeatherDataResult

/**
 * Created by xiaoming on 2017/8/23.
 */

class WeatherRequestCommand(val weatherDataResult: WeatherDataResult) : Command<WeatherList> {
    override fun execute(): WeatherList {
        return WeatherDataMapper().convertFromDataModel(weatherDataResult)
    }
}
