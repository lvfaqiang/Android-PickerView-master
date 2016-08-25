package com.bigkoo.pickerviewdemo;

import android.content.Context;

import com.lvfq.pickerview.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * --------------------------------------------
 * Create By :  Lvfq
 * Date ： 2016/8/25 0025 下午 5:50
 * -------------------------------------------
 **/
public class Util {

    /**
     * 时间选择回调
     */
    public interface TimerCallBack {
        void onTimeSelect(String date);
    }

    /**
     * 弹出时间选择
     *
     * @param context
     * @param type     TimerPickerView 中定义的 选择时间类型
     * @param format   时间格式化
     * @param callBack 时间选择回调
     */
    public static void alertTimerPicker(Context context, TimePickerView.Type type, final String format, final TimerCallBack callBack) {
        TimePickerView pvTime = new TimePickerView(context, type);
        //控制时间范围
        //        Calendar calendar = Calendar.getInstance();
        //        pvTime.setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR));
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);
        //时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
//                        tvTime.setText(getTime(date));
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                callBack.onTimeSelect(sdf.format(date));
            }
        });
        //弹出时间选择器
        pvTime.show();
    }
}
