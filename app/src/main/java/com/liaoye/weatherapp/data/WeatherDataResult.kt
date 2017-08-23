package com.liaoye.weatherapp.data

/**
 * Created by xiaoming on 2017/8/23.
 */
data class WeatherDataResult(
        val reason: String,
        val result: WeatherResult,
        val error_code: Int
)

data class WeatherResult(val data: WeatherData)

data class WeatherData(
    val realtime: RealTime,
    val weather: List<WeatherInfo>,
    val f3h: F3H,
    val pm25: PM25,
    val jingqu: String,
    val jingqutq: String,
    val date: String,
    val isForeign: String
)

data class RealTime(
    val city_code: String,
    val city_name: String,
    val date: String,
    val time: String,
    val week: Int,
    val moon: String,
    val dataUptime: String,
    val weather: Weather,
    val wind: Wind
)

data class Weather(
    val temperature: String,
    val humidity: String,
    val info: String,
    val img: String
)

data class Wind(
    val direct: String,
    val power: String,
    val offset: String,
    val windspeed: String
)


data class WeatherInfo(
    val date: String,
    val info: WeatherDetail,
    val week: String,
    val nongli: String
)

data class WeatherDetail(
    val day: List<String>,
    val night: List<String>
)

data class F3H(
        val temperature: List<Temperature>,
        val precipitation: List<Precipitation>
)

data class Temperature(
        val jg: String,
        val jb: String
)

data class Precipitation(
        val jg: String,
        val jf: String
)

data class PM25(
        val key: String,
        val show_desc: Int,
        val pm25: PM25Detail,
        val dateTime: String,
        val cityName: String
)

data class PM25Detail(
        val curPm: String,
        val pm25: String,
        val pm10: String,
        val level: Int,
        val quality: String,
        val des: String
)