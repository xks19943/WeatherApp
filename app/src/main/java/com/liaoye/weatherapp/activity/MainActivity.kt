package com.liaoye.weatherapp.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.liaoye.weatherapp.R
import com.liaoye.weatherapp.adapter.WeatherAdapter
import com.liaoye.weatherapp.domain.WeatherRequestCommand
import com.liaoye.weatherapp.network.WeatherRequest
import com.liaoye.weatherapp.views.MyRecyclerView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv_weather = findViewById<MyRecyclerView>(R.id.rv_weather);
        val tv_area = findViewById<TextView>(R.id.tv_area)
        val tv_temperature = findViewById<TextView>(R.id.tv_temperature)
        val tv_date = findViewById<TextView>(R.id.tv_date)
        val tv_humidity = findViewById<TextView>(R.id.tv_humidity)
        val tv_info = findViewById<TextView>(R.id.tv_info)
        val tv_direct = findViewById<TextView>(R.id.tv_direct)
        val tv_power = findViewById<TextView>(R.id.tv_power)
        val tv_aqi = findViewById<TextView>(R.id.tv_aqi)

//        val tv_chuanyi = findViewById<TextView>(R.id.tv_chuanyi)
//        val tv_chuanyiDesc = findViewById<TextView>(R.id.tv_chuanyiDesc)
//        val tv_ganmao = findViewById<TextView>(R.id.tv_ganmao)
//        val tv_ganmaoDesc = findViewById<TextView>(R.id.tv_ganmaoDesc)
//        val tv_kongtiao = findViewById<TextView>(R.id.tv_kongtiao)
//        val tv_kongtiaoDesc = findViewById<TextView>(R.id.tv_kongtiaoDesc)
//        val tv_xiche = findViewById<TextView>(R.id.tv_xiche)
//        val tv_xicheDesc = findViewById<TextView>(R.id.tv_xicheDesc)
//        val tv_yundong = findViewById<TextView>(R.id.tv_yundong)
//        val tv_yundongDesc = findViewById<TextView>(R.id.tv_yundongDesc)
//        val tv_ziwaixian = findViewById<TextView>(R.id.tv_ziwaixian)
//        val tv_ziwaixianDesc = findViewById<TextView>(R.id.tv_ziwaixianDesc)


        rv_weather.layoutManager = LinearLayoutManager(this)
        val cityName: String = "广州"
        val city = URLEncoder.encode(cityName, "UTF-8")

        doAsync {
            val weatherResult = WeatherRequest(city).execute()
            uiThread {
                if(weatherResult.error_code == 0){
                    val realTime = weatherResult.result.realtime
//                    val lifeInfo = weatherResult.result.data.life.info
//                    val weatherInfo = realTime.weather
                    val weatherList = WeatherRequestCommand(weatherResult).execute()
                    tv_area.text = weatherResult.result.city
                    tv_date.text = weatherList.weather[0].date
                    tv_temperature.text = "${realTime.temperature}°"
                    tv_humidity.text = "湿度：${realTime.humidity}"
                    tv_direct.text = "风向：${realTime.direct}"
                    tv_power.text = "风力：${realTime.power}"
                    tv_aqi.text = "空气质量指数：${realTime.aqi}"
                    tv_info.text = "天气情况：${realTime.info}"

//                    tv_chuanyi.text = lifeInfo.chuanyi[0]
//                    tv_chuanyiDesc.text = lifeInfo.chuanyi[1]
//                    tv_ganmao.text = lifeInfo.ganmao[0]
//                    tv_ganmaoDesc.text = lifeInfo.ganmao[1]
//                    tv_kongtiao.text = lifeInfo.kongtiao[0]
//                    tv_kongtiaoDesc.text = lifeInfo.kongtiao[1]
//                    tv_xiche.text = lifeInfo.xiche[0]
//                    tv_xicheDesc.text = lifeInfo.xiche[1]
//                    tv_yundong.text = lifeInfo.yundong[0]
//                    tv_yundongDesc.text = lifeInfo.yundong[1]
//                    tv_ziwaixian.text = lifeInfo.ziwaixian[0]
//                    tv_ziwaixianDesc.text = lifeInfo.ziwaixian[1]

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

