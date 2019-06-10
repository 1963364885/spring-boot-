package com.service;

import com.base.ServiceContain;
import com.mapper.UserMapper;
import com.pojo.User;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created on 2018.06.11.
 */
@Service
public class UserService extends ServiceContain {
    User user = new User();
    String u = user.getUsername();

    //登陆
    public SiteResponse login(User user) {

        String s = "登陆成功";
        int i[]=new int[200];
        int d=0,c=0;
        List<User> userList1=userMapper.zaixian(user);
        userList1.size();
        System.out.println(userList1.size()+"登陆人数");
//        for(User user1:userList1){
//            System.out.println(user1.getState()+"0123");
//            System.out.println(user1);
//
//                d = user1.getState();
//                if (d == 1) {
//                    i[c] = d;
//                    c++;
//
//            }
//        }
       // System.out.println(  i.length+"登陆人数");
        List<User> userList = userMapper.login(user);
        if (yanzheng == true) {
            return returnResponse(userList, "登陆成功", true);
        } else {
            return returnResponse(userList, "登陆失败", false);
        }
    }
     //查询
    public SiteResponse cha(User user) {
        List<User> userList = userMapper.cha(user);

        User a[]=new User[userList.size()];
        int i=0;
        //把值存入a数组
        for(User user1:userList){
            a[i]=user1;
            i++;
        }
        return returnResponse(userList, "查询成功", false);
    }

    //插入
    public SiteResponse register(User user) {
            if(n==0) {
                return returnResponse("1", "该账号已存在", false);
            }
            if(n==1){
                return returnResponse("1", "密码长度有错", false);
            }
            if(n==2)
                return returnResponse("1", "真实姓名只能输入汉字", false);
            if(n==3)
            return returnResponse("1", "密码只能输入数字", false);

                userMapper.register(user);
                return returnResponse("1", "注册成功", true);


    }

    //修改
    public  SiteResponse update(User user){
        String i="修改成功";
       userMapper.update(user);
        return  returnResponse("1",i,true);
    }
    //删除
    public SiteResponse delete(User user){
        String c=null,b=null;
        int a=0,d=0;
        HttpSession session = request.getSession();
        if(!"null".equals(session.getAttribute("uid"))) {
            d = Integer.parseInt(session.getAttribute("uid") + "");
        }
        user.setState(0);
        user.setId(d);
        userMapper.zhuang(user);
        Object userInfo = session.getAttribute("userInfo");
        session.removeAttribute("userinfo");
        session.removeAttribute("uid");
        session.removeAttribute("userid");

        if(userInfo==null){
            return  returnResponse("1","退出成功",true);
        }if(userInfo!=null) {
            return  returnResponse("1","退出失败",true);
        }
         //userMapper.delete(user);
        return  returnResponse("1","删除成功",true);

    }

}
