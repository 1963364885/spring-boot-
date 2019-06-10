package com.controller;

import com.base.ServiceContain;
import com.pojo.Demands;
import com.pojo.User;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created on 2018.06.11.
 */

@Controller
@RequestMapping("/api/user")
public class UserController extends ServiceContain {
User user= new User();
    //登陆
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public   SiteResponse login(@RequestBody User user) {

       // System.out.println(user.getUsername()+"  456");
        //        user.setUsername(username);
    //System.out.println(user.getUsername()+"  "+user.getPassword());
        String a=null;
        int id=0;
        String c=user.getPassword();
        List<User> userList = userMapper.login(user);
        for(User user1:userList){
           id=user1.getId();
            if(user1.getPassword()!=null) {
                a = user1.getPassword();
            }
        }
        if(a==null||!a.equals(user.getPassword())){
            yanzheng=false;
            return userService.login(user);
        }
        user.setState(1);
          user.setId(id);
          userMapper.zhuang(user);
        // uname=request.getSession().getAttribute("userid");
        yanzheng=true;



        if(session.getAttribute("userinfo")==null){
            request.getSession().setAttribute("userinfo",user.getUsername()+user.getPassword());
            request.getSession().setAttribute("userid",user.getUsername());
            request.getSession().setAttribute("uid",id);
            size++;
        }else {
          //  System.out.println(size+"用户在线人数");
        }
        return userService.login(user);
    }
    //c查询
    @RequestMapping(value = "/cha", method = RequestMethod.GET)
    @ResponseBody
    public   SiteResponse cha(@ModelAttribute User user) {

        return userService.cha(user);
    }
    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse register(@RequestBody User user){



        System.out.println(user.getUsername()+user.getPassword()+user.getName());

       //判断是否已经有用户
        String b=null;
        List<User> userList = userMapper.login(user);
        for(User user1:userList){
            if(user1.getUsername()!=null) {
                b = user1.getUsername();
            }
    }
        if(b!=null&&b.equals(user.getUsername())){
            n=0;
            System.out.println(b+"xx"+user.getUsername());
            return userService.register(user);
        }

//        for(int i=user.getPassword().length();--i>=0; ){
//            int chr=user.getPassword().charAt(i);
//            if (chr<48||chr>57){
//                System.out.println("密码只能是数字");
//            }
//        }
        Date date=new Date();
        java.sql.Timestamp sqld = new java.sql.Timestamp(date.getTime());//获取时间，这种方法可以不用转换
        System.out.println("当前日期时间：" + sqld);
        user.setCreate_time(sqld);//
        user.setState(0);
        String str=user.getPassword();
        //设置密码必须是数字，如果不是数字就将密码和账号都修改为空存入数据库
//        try{
//            Integer.parseInt(str);
//        }catch(NumberFormatException e) {
//           System.out.println("异常：\"" + str+ "\"不是数字!");
//           n=false;
//           return null;
//
//        }

        //设置密码长度为8到10位，如果不是就将密码和账号都修改为空存入数据库
        if (str.length()<2||str.length()>10){
            System.out.println("密码长度在8到10位");
             n=1;
            return userService.register(user);
        }
        //判断姓名是否为汉字,密码只能为数字
        String reg = "[\\u4e00-\\u9fa5]+" ;
        String reg1 = "[0-9]+" ;
        boolean result1 = user.getName().matches(reg);//false
        boolean result2 = user.getPassword().matches(reg1);//false
        if (result1==true){
            n=4;
            return userService.register(user);
        }
        if(result1==false){
            n=2;
            return userService.register(user);
        }
        if (result1==true){
            n=4;
            return userService.register(user);
        }
        if(result1==false){
            n=3;
            return userService.register(user);
        }
        n=4;
        yanzheng=true;
        return userService.register(user);


    }
    //修改
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse update(@ModelAttribute User user){
        return userService.update(user);
    }
    //删除
    @RequestMapping(value="/delete",method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse delete(@ModelAttribute User user){


        return userService.delete(user);
    }
}
