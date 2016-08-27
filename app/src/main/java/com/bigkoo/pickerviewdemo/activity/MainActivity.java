package com.bigkoo.pickerviewdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerviewdemo.DataModel;
import com.bigkoo.pickerviewdemo.R;
import com.bigkoo.pickerviewdemo.Util;
import com.bigkoo.pickerviewdemo.bean.ProvinceBean;
import com.lvfq.pickerview.OptionsPickerView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private ArrayList<ProvinceBean> options1Items = new ArrayList<ProvinceBean>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<ArrayList<ArrayList<String>>>();

    private ArrayList<String> mList = new ArrayList<String>();
    private TextView tvTime, tvOptions;
    private TextView tv_single_option;

    OptionsPickerView pvOptions;
    View vMasker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vMasker = findViewById(R.id.vMasker);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvOptions = (TextView) findViewById(R.id.tvOptions);
        tv_single_option = (TextView) findViewById(R.id.tv_single_option);

        // 时间选择
        tvTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });

        // 单项选择
        for (int i = 0; i <= 10; i++) {
            mList.add("模拟数据" + i);
        }

        tv_single_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.alertBottomWheelOption(MainActivity.this, mList, new Util.OnWheelViewClick() {
                    @Override
                    public void onClick(View view, int postion) {
                        Toast.makeText(MainActivity.this, mList.get(postion), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        showOptions();
    }

    private void showOptions(){
        //选项选择器
        pvOptions = new OptionsPickerView(this);
        // 初始化三个列表数据
        DataModel.initData(options1Items, options2Items, options3Items);

        //三级联动效果
        pvOptions.setPicker(options1Items, options2Items, options3Items, true);
        //设置选择的三级单位
//        pwOptions.setLabels("省", "市", "区");
        pvOptions.setTitle("选择城市");
        pvOptions.setCyclic(false, false, false);
        //设置默认选中的三级项目
        //监听确定选择按钮
        pvOptions.setSelectOptions(1, 1, 1);
        pvOptions.setTextSize(18);
        pvOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {

            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText()
                        + options2Items.get(options1).get(option2)
                        + options3Items.get(options1).get(option2).get(options3);
                tvOptions.setText(tx);
                vMasker.setVisibility(View.GONE);
            }
        });
        //点击弹出选项选择器
        tvOptions.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pvOptions.show();
            }
        });
    }

}
