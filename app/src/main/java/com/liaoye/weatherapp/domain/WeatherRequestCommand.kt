package com.liaoye.weatherapp.domain

import com.liaoye.weatherapp.data.WeatherDataResult
import com.liaoye.weatherapp.network.WeatherRequest

/**
 * Created by xiaoming on 2017/8/23.
 */

class WeatherRequestCommand(val weatherDataResult: WeatherDataResult):Command<WeahterList>{
    override fun execute(): WeahterList {
        return WeatherDataMapper().convertFromDataModel(weatherDataResult)
    }
}
