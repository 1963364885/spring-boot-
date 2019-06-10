package com.base;

import com.pojo.other.SiteResponse;
import com.service.DemandsService;
import com.service.TaskService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by li on 2017/11/27.
 */
public class ServiceContain extends MapperContain {
    //用户
    @Autowired
    public UserService userService;
    @Autowired
    public DemandsService demandsService;
    @Autowired
    public TaskService taskService;
    @Autowired
    public HttpSession session;
    @Autowired
     public   HttpServletRequest request;
    @Autowired
    public ApplicationContext applicationContext;

    public static int i[] =new int[50];
    public static int sid[];
    public static int n=0;
    public static Boolean yanzheng;
    public static long size;



    //返回前端数据
    public SiteResponse returnResponse(Object data, String msg, Boolean state) {
        SiteResponse siteResponse = new SiteResponse();
        siteResponse.map.put("data", data);
        siteResponse.setMsg(msg);
        siteResponse.setState(state);
        return siteResponse;
    }
//    public SiteResponse returnRes(Demands a[] , String m){
//        SiteResponse siteResponse = new SiteResponse();
//        siteResponse
//
//    }


}
