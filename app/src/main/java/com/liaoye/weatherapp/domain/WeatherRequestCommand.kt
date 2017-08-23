package com.liaoye.weatherapp.domain

import com.liaoye.weatherapp.network.WeatherRequest

/**
 * Created by xiaoming on 2017/8/23.
 */

class WeatherRequestCommand(val cityName: String):Command<WeahterList>{
    override fun execute(): WeahterList {
        val weatherRequest = WeatherRequest(cityName)
        return WeatherDataMapper().convertFromDataModel(weatherRequest.execute())
    }
}
