package com.liaoye.weatherapp.network

import android.util.Log
import com.google.gson.Gson
import com.liaoye.weatherapp.data.WeatherDataResult
import java.net.URL

/**
 * Created by xiaoming on 2017/8/23.
 */
class WeatherRequest(val cityName: String){
    companion object{
        private val key= "8ff5fde1ef5b35438e8716e27ffc63b8"
        private val URL = "http://op.juhe.cn/onebox/weather/query?"
        private val COMPLETE_URL = "$URL+key=$key&cityname="
    }

    fun execute(): WeatherDataResult{
        Log.d(javaClass.simpleName, COMPLETE_URL + cityName)
        val weatherStr = URL(COMPLETE_URL + cityName).readText()
        Log.d(javaClass.simpleName, weatherStr)
        return Gson().fromJson(weatherStr,WeatherDataResult::class.java)
    }
}