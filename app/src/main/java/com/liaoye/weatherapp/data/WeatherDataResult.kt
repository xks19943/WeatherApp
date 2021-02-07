package com.liaoye.weatherapp.data

/**
 * Created by xiaoming on 2017/8/23.
 */
data class WeatherDataResult(
    val reason: String,
    val result: WeatherResult,
    val error_code: Int
)

data class WeatherResult(
    val realtime: RealTime,
    val city: String,
    val future: List<Future>
)


data class RealTime(
    val temperature: String,
    val humidity: String,
    val info: String,
    val wid: String,
    val direct: String,
    val power: String,
    val aqi: String
)

data class Future(
    val date: String,
    val temperature: String,
    val weather: String,
    val wid: Wid,
    val direct: String
)

data class Wid(
    val day: String,
    val night: String
)
/*

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
        val dawn: List<String>?,
        val day: List<String>?,
        val night: List<String>?
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

data class Life(
        val date: String,
        val info: LifeInfo
)

data class LifeInfo(
        val chuanyi: List<String>,
        val ganmao: List<String>,
        val kongtiao: List<String>,
        val xiche: List<String>,
        val yundong: List<String>,
        val ziwaixian: List<String>
)
*/

