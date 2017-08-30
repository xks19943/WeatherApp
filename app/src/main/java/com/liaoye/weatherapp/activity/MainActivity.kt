package com.liaoye.weatherapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import com.liaoye.weatherapp.R
import com.liaoye.weatherapp.adapter.WeatherAdapter
import com.liaoye.weatherapp.domain.WeatherRequestCommand
import com.liaoye.weatherapp.network.WeatherRequest
import com.liaoye.weatherapp.views.MyRecyclerView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.net.URLEncoder
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv_weather = findViewById(R.id.rv_weather) as MyRecyclerView
        val tv_area = findViewById(R.id.tv_area) as TextView
        val tv_temperature = findViewById(R.id.tv_temperature) as TextView
        val tv_date = findViewById(R.id.tv_date) as TextView
        val tv_time = findViewById(R.id.tv_time) as TextView
        val tv_week = findViewById(R.id.tv_week) as TextView
        val tv_moon = findViewById(R.id.tv_moon) as TextView

        val tv_chuanyi = findViewById(R.id.tv_chuanyi) as TextView
        val tv_chuanyiDesc = findViewById(R.id.tv_chuanyiDesc) as TextView
        val tv_ganmao = findViewById(R.id.tv_ganmao) as TextView
        val tv_ganmaoDesc = findViewById(R.id.tv_ganmaoDesc) as TextView
        val tv_kongtiao = findViewById(R.id.tv_kongtiao) as TextView
        val tv_kongtiaoDesc = findViewById(R.id.tv_kongtiaoDesc) as TextView
        val tv_xiche = findViewById(R.id.tv_xiche) as TextView
        val tv_xicheDesc = findViewById(R.id.tv_xicheDesc) as TextView
        val tv_yundong = findViewById(R.id.tv_yundong) as TextView
        val tv_yundongDesc = findViewById(R.id.tv_yundongDesc) as TextView
        val tv_ziwaixian = findViewById(R.id.tv_ziwaixian) as TextView
        val tv_ziwaixianDesc = findViewById(R.id.tv_ziwaixianDesc) as TextView


        rv_weather.layoutManager = LinearLayoutManager(this)
        val cityName: String = "广州"
        val city = URLEncoder.encode(cityName, "UTF-8")

        doAsync {
            val weatherResult = WeatherRequest(city).execute()
            uiThread {
                if(weatherResult.error_code == 0){
                    val realTime = weatherResult.result.data.realtime
                    val lifeInfo = weatherResult.result.data.life.info
                    val weatherInfo = realTime.weather
                    val weatherList = WeatherRequestCommand(weatherResult).execute()
                    tv_area.text = realTime.city_name
                    tv_date.text = realTime.date
                    tv_time.text = realTime.time
                    tv_week.text = getWeekDay(realTime.week)
                    tv_temperature.text = weatherInfo.temperature
                    tv_moon.text = realTime.moon

                    tv_chuanyi.text = lifeInfo.chuanyi[0]
                    tv_chuanyiDesc.text = lifeInfo.chuanyi[1]
                    tv_ganmao.text = lifeInfo.ganmao[0]
                    tv_ganmaoDesc.text = lifeInfo.ganmao[1]
                    tv_kongtiao.text = lifeInfo.kongtiao[0]
                    tv_kongtiaoDesc.text = lifeInfo.kongtiao[1]
                    tv_xiche.text = lifeInfo.xiche[0]
                    tv_xicheDesc.text = lifeInfo.xiche[1]
                    tv_yundong.text = lifeInfo.yundong[0]
                    tv_yundongDesc.text = lifeInfo.yundong[1]
                    tv_ziwaixian.text = lifeInfo.ziwaixian[0]
                    tv_ziwaixianDesc.text = lifeInfo.ziwaixian[1]

                    val adpter = WeatherAdapter(weatherList.weather)
                    rv_weather.adapter = adpter

                    toast("获取数据成功")
                }

            }
        }
    }

    private fun getWeekDay(week: Int): String{
        var weekDay:String = ""
        when(week){
            0 -> weekDay = "星期日"
            1 -> weekDay = "星期一"
            2 -> weekDay = "星期二"
            3 -> weekDay = "星期三"
            4 -> weekDay = "星期四"
            5 -> weekDay = "星期五"
            6 -> weekDay = "星期六"
        }
        return weekDay
    }
}

