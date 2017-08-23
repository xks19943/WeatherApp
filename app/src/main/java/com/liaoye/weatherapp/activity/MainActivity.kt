package com.liaoye.weatherapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.liaoye.weatherapp.R
import com.liaoye.weatherapp.adapter.WeatherAdapter
import com.liaoye.weatherapp.domain.WeatherRequestCommand
import com.liaoye.weatherapp.network.WeatherRequest
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv_weather = findViewById(R.id.rv_weather) as RecyclerView
        rv_weather.layoutManager = LinearLayoutManager(this)
        doAsync {
            val weatherList = WeatherRequestCommand("%E5%B9%BF%E5%B7%9E").execute()
            //val list = WeatherRequest("%E5%B9%BF%E5%B7%9E").execute()
            uiThread {
                rv_weather.adapter = WeatherAdapter(weatherList.weather)
                toast("获取数据成功")
            }
        }
    }
}

