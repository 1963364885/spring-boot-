package com.pojo;

import com.base.ServiceContain;

import java.util.Date;

/**
 * Created on 2018.08.14.
 */
public class User extends ServiceContain {
    public int id;
    public  int state;
    public String username;
    public String password;
    public String name;
    public Date create_time;
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
