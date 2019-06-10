package com.controller;

import com.base.ServiceContain;
import com.pojo.Demands;
import com.pojo.Task;
import com.pojo.other.SiteResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/task")
public class TaskController extends ServiceContain {
    //分配
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse zhen(@RequestBody Task task){
        System.out.println(task.getName()+" "+task.getCreate_time()+" "+task.getContent()+" "+task.getCreator());
        return taskService.zhen(task);

    }
    //查
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse cha(@ModelAttribute Task task){

        return taskService.cha(task);

    }
   //名字查询
    @RequestMapping(value = "/dancha", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse dcha(@RequestBody Task task){
        if (task.getName()!=null){
            return taskService.dcha(task);
        }

        return taskService.creatorcha(task);

    }
    //删除
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @ResponseBody
    public SiteResponse shan(@RequestBody Task task){

        return taskService.shan(task);

    }
    //修改
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public SiteResponse gai(@RequestBody Task task){
        System.out.println(task.getName()+task.getContent()+task.getId());
        return taskService.gai(task);
    }
    //单独修改状态的接口
    @RequestMapping(value = "/wan", method = RequestMethod.PUT)
    @ResponseBody
    public SiteResponse wan(@RequestBody Task task){
       return taskService.wan(task);
    }


}
