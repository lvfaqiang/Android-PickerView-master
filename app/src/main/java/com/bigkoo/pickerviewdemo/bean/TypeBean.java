package com.bigkoo.pickerviewdemo.bean;

/**
 * --------------------------------------------
 * Create By :  Lvfq
 * Date ： 2016/8/28 0028 下午 3:55
 * -------------------------------------------
 **/
public class TypeBean {

    private int id;
    private String name;

    public TypeBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //这个用来显示在PickerView上面的字符串,PickerView会通过反射获取getPickerViewText方法显示出来。
    public String getPickerViewText() {
        //这里还可以判断文字超长截断再提供显示
        return name;
    }
}
