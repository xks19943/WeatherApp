package com.liaoye.weatherapp.views

import android.content.Context
import android.graphics.Canvas
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

/**ScrollView嵌套RecyclerView时候重新测量ziview的高度
 * Created by xiaoming on 2017/8/30.
 */
class MyRecyclerView(context: Context?, attrs: AttributeSet?) : RecyclerView(context, attrs) {

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        //测量参数是最大值右移2位
        val measureSpec = MeasureSpec.makeMeasureSpec(Int.MAX_VALUE shr 2, MeasureSpec.AT_MOST)
        super.onMeasure(widthSpec, measureSpec)
    }

    override fun onDraw(c: Canvas?) {
        super.onDraw(c)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
    }
}