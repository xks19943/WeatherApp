package com.liaoye.weatherapp.views

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.liaoye.weatherapp.R
import org.jetbrains.anko.find

/**
 * Created by xiaoming on 2017/8/30.
 */
class DaysWeatherView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private val view: View
    private val tv_day: TextView
    private val tv_weather: TextView
    private val tv_temperature: TextView
    private val tv_direct: TextView
    private val tv_power: TextView

    init {
        view = LayoutInflater.from(context).inflate(R.layout.item_weatherinfo, this)
        tv_day = view.find(R.id.tv_day)
        tv_weather = view.find(R.id.tv_weather)
        tv_temperature = view.find(R.id.tv_temperature)
        tv_direct = view.find(R.id.tv_direct)
        tv_power = view.find(R.id.tv_power)
    }

    fun setDaysOfWeaher(list: List<String>, type: Int) {
        Log.i("天气",list[1])
        if(type == 0){
            tv_day.text = "黎明"
        }else if(type == 1){
            tv_day.text = "白天"
        }else if(type == 2){
            tv_day.text = "黑夜"
        }
        tv_weather.text = "天气：${list[1]}"
        tv_temperature.text = "温度：${list[2]}"
        tv_direct.text = "风向：${list[3]}"
        tv_power.text = "风力：${list[4]}"
    }


}