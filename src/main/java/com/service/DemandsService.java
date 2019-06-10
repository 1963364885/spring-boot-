package com.service;

import com.base.ServiceContain;
import com.pojo.Demands;
import com.pojo.User;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created on 2018.06.11.
 */
@Service
public class DemandsService extends ServiceContain {
   Demands demands=new Demands();
   User user=new User();
    //多查询
    public SiteResponse cha(Demands demands) {

        List<Demands> demandsList =demandsMapper.cha(demands);
        Demands a[]=new Demands[demandsList.size()];
        int i=0;
        //把值存入a数组
        for(Demands demands1:demandsList){
                a[i]=demands1;
                i++;
        }
            return returnResponse(a, "多查询成功", true);

    }
    //单查询
    public  SiteResponse creatorcha(Demands demands){

        List<Demands> demandsList =demandsMapper.creatorcha(demands);
        Demands a[]=new Demands[demandsList.size()];
        int c=0;
        for(Demands demands1:demandsList){
            a[c]=demands1;
            c++;
        }
        return returnResponse(a, "作者查询成功", true);
    }
    //名字查询
    public  SiteResponse dcha(Demands demands){
        List<Demands> demandsList =demandsMapper.dcha(demands);
        Demands a[]=new Demands[demandsList.size()];
        int c=0;
        for(Demands demands1:demandsList){
            a[c]=demands1;
            c++;
        }
        return returnResponse(a, "名字查询成功", true);
    }
    //添加
    public SiteResponse zhen(Demands demands ) {
        user.setUsername(demands.getUsername());
        HttpSession session = request.getSession();
        String c=null,b=null;
        int a=0,d=0;
        //null不等与  session.getAttribute("uid");
        if(!"null".equals(session.getAttribute("uid"))) {
            session.getAttribute("uid");
            d = Integer.parseInt(session.getAttribute("uid") + "");
            System.out.println(request.getSession().getAttribute("uid"));
        }
        List<Demands> demandsList = demandsMapper.dcha(demands);
        demands.getUsername();
        List<User> userList = demandsMapper.ucha(user);
        for(User user1:userList){
            if(user1.getId()!=0) {
               a=user1.getId();
            }
        }
        for(Demands demands1:demandsList){
            if(demands1.getName()!=null){
                c=demands1.getName();
            }
        }
        System.out.println(demands.getUsername());
        System.out.println(a);

        if(c!=null&&c.equals(demands.getName())){
            return returnResponse("1","该需求已存在",true);
        }
        if (demands.getContent()==null){
            return  returnResponse("1","请填写你需求的内容",true);
        }
        if (demands.getName()==null){
            return  returnResponse("1","请填写你的需求",true);
        }
        Demands demands1=new Demands();
        Date date=new Date();
        java.sql.Timestamp shijian = new java.sql.Timestamp(date.getTime());//获取时间，这种方法可以不用转换
        System.out.println("当sqld1前日期时间：" + shijian);
        demands1.setCreate_time(shijian);
        demands1.setId(demands.getId());
        demands1.setName(demands.getName());
        demands1.setContent(demands.getContent());
        demands1.setCreator(d);
        System.out.println(demands1.getCreate_time()+"获取时间");
            demandsMapper.zhen(demands1);
            return returnResponse(1, "添加成功", true);
    }

    //修改
    public  SiteResponse gai(Demands demands){
        System.out.println(demands.getId()+" "+demands.getName()+"  "+demands.getContent());
        if(demands.getName()==null){
            return returnResponse("1","需求名字不能为空",false);
        }
        if(demands.getContent()==null){
            return returnResponse("1","需求内容不能为空",false);
        }
        if(demands.getId()==0){
            return returnResponse("1","id没传过来",false);
        }
        demandsMapper.gai(demands);
        return  returnResponse("1","修改成功",true);
    }
    //删除
    public SiteResponse shan(Demands demands){
      // System.out.println(demands.getId());
        demandsMapper.shan(demands);
        return  returnResponse("1","删除成功",true);
    }
    //多删
    public  SiteResponse duoshan(Demands demands){
        int i=0;
        int did=0;
        for(i=0;i<sid.length;i++){
            //did=Integer.parseInt(sid[i]);
            did=sid[i];
            demands.setId(did);
            System.out.println(sid.length);
           demandsMapper.shan(demands);
        }
        return returnResponse("1","删除成功",true);
    }

}
