package com.bigkoo.pickerviewdemo;

import android.app.Activity;
import android.os.Bundle;

import com.lvfq.pickerview.adapter.ArrayWheelAdapter;
import com.lvfq.pickerview.lib.WheelView;
import com.bigkoo.pickerviewdemo.bean.TestBean;

import java.util.ArrayList;

/**
 * --------------------------------------------
 * Create By :  Lvfq
 * Date ： 2016/8/15 0015 下午 4:45
 * -------------------------------------------
 **/
public class WheelTest extends Activity {

    private WheelView wheelView;

    private ArrayList<TestBean> list = new ArrayList<TestBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheelview_test);

        TestBean bean1 = new TestBean(1, "test1", "type1");
        TestBean bean2 = new TestBean(2, "test2", "type2");
        TestBean bean3 = new TestBean(3, "test3", "type3");
        TestBean bean4 = new TestBean(4, "test4", "type4");
        TestBean bean5 = new TestBean(5, "test5", "type5");
        TestBean bean6 = new TestBean(6, "test6", "type6");
        TestBean bean7 = new TestBean(7, "test7", "type7");
        TestBean bean8 = new TestBean(8, "test8", "type8");
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        list.add(bean5);
        list.add(bean6);
        list.add(bean7);
        list.add(bean8);


        wheelView = (WheelView) findViewById(R.id.options);
        wheelView.setAdapter(new ArrayWheelAdapter(list));
        wheelView.setCurrentItem(0);
        wheelView.setLabel("测");
        wheelView.setTextSize(20);
        wheelView.setCyclic(false);

    }
}
