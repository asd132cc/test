package com.ssm.controller.vo;

import java.util.List;


public class LayuiReturn<T> {

    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LayuiReturn{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public static <T> LayuiReturn<T> convert(Integer count, List<T> data) {
        LayuiReturn<T> l = new LayuiReturn<T>();
        l.code = 0;
        l.msg = "";
        l.count = count;
        l.data = data;
        return l;
    }

    public LayuiReturn setProperty(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }
}
