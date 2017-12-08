package com.visizen.dto;

import org.springframework.stereotype.Component;

/**
 * 封装返回结果
 */
//@Component
public class ResultDto<T> {
    private int code;
    private  String msg;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private  T data;



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
