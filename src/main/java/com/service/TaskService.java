package com.service;

import com.base.ServiceContain;
import com.pojo.Demands;
import com.pojo.Task;
import com.pojo.User;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class TaskService  extends ServiceContain {
    Demands demands=new Demands();
    User user=new User();
    //分配任务
    public SiteResponse zhen(Task task) {
        List<Demands> demandsList =demandsMapper.cha(demands);
        Demands a[]=new Demands[demandsList.size()];
        int i=0;
        //把值存入a数组
        for(Demands demands1:demandsList){
            a[i]=demands1;
            i++;
        }
        Task task1=new Task();
        Date date1=new Date();
        java.sql.Timestamp shijian = new java.sql.Timestamp(date1.getTime());//获取时间，这种方法可以不用转换
        //将前端的时间进行转码，存入数据库。是再实体类里写了一个String类型 time变量来接收前端传值，再把time转换为Date存给create_time
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = null;
        String str = null;
        java.sql.Timestamp shijian1=null;
         // String转Date
         str = "2007-1-18";
         try {
                       date = format1.parse(task.getTime());
           shijian1 = new java.sql.Timestamp(date.getTime());

             } catch (ParseException e) {
                        e.printStackTrace();
             }

        task1.setStart_time(shijian);//开始时间
        task1.setCreate_time(shijian1);
        task1.setContent(task.getContent());
        task1.setCreator(task.getCreator());
        task1.setName(task.getName());
        task1.setExecutor(task.getExecutor());
        taskMapper.zhen(task1);

        return returnResponse(1, "任务分配成功", true);
    }
    //查询
    public SiteResponse cha(Task task) {
        List<Task> taskList =taskMapper.cha(task);
        Task a[]=new Task[taskList.size()];
        int i=0;
        //把值存入a数组
        for(Task task1:taskList){
            a[i]=task1;
            i++;
        }
        return returnResponse(taskList, "任务查询成功", true);
    }

    //单查询
    public  SiteResponse creatorcha(Task task){
        List<Task> taskList =taskMapper.creatorcha(task);
        Task a[]=new Task[taskList.size()];
        int i=0;
        //把值存入a数组
        for(Task task1:taskList){
            a[i]=task1;
            i++;
        }
        return returnResponse(taskList, "创建人查询成功", true);
    }

    public  SiteResponse dcha(Task task){
        List<Task> taskList =taskMapper.dcha(task);
        Task a[]=new Task[taskList.size()];
        int i=0;
        //把值存入a数组
        for(Task task1:taskList){
            a[i]=task1;
            i++;
        }
        return returnResponse(taskList, "名字查询成功", true);
    }

    //删除
    public SiteResponse shan(Task task) {
        if(task.getState()==1){
            return returnResponse(1, "已完成的任务不可删除", false);
        }
        taskMapper.shan(task);
        return returnResponse(1, "删除成功", true);
    }
    //修改
    public SiteResponse gai(Task task) {
        Date date1=new Date();
        java.sql.Timestamp shijian = new java.sql.Timestamp(date1.getTime());//获取时间，这种方法可以不用转换
        System.out.println(shijian+" 45678");
        if(task.getState()==1){
            task.setFinish_time(shijian);
        }
        if(task.getState()==0){
            task.setFinish_time(null);
        }
        System.out.println(task.getFinish_time());
        taskMapper.gai(task);
        return returnResponse(task.getState(), "修改成功", true);
    }
    //单独修改状态
    public SiteResponse wan(Task task) {
        Date date1=new Date();
        java.sql.Timestamp shijian = new java.sql.Timestamp(date1.getTime());//获取时间，这种方法可以不用转换
        task.setFinish_time(shijian);
        taskMapper.wan(task);
        return returnResponse(task.getState(), "状态修改成功", true);
    }
}
