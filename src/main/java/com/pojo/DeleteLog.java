package com.pojo;

import com.base.ServiceContain;

public class DeleteLog extends ServiceContain {
    private  int id;
    private  int data;
    private String msg;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
