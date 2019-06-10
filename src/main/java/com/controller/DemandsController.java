package com.controller;

import com.base.ServiceContain;
import com.pojo.Demands;
import com.pojo.other.SiteResponse;
import com.service.DemandsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/demands")
public class DemandsController extends ServiceContain {
    //查
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public SiteResponse cha(@ModelAttribute Demands demands){

        return demandsService.cha(demands);

    }
    //单查
    @RequestMapping(value = "/dancha", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse dancha(@RequestBody Demands demands){
        System.out.println(demands.getCreator());
        System.out.println(demands.getName());
        if(demands.getName()!=null) {

            return demandsService.dcha(demands);//name查询
        }
        return demandsService.creatorcha(demands);

    }
    //增加
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public SiteResponse zhen(@RequestBody Demands demands){

        return demandsService.zhen(demands);

    }
    //删除
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @ResponseBody
    public SiteResponse shan(@RequestBody Demands demands){

        return demandsService.shan(demands);

    }
    //多删除
    @RequestMapping(value = "/duoshan", method = RequestMethod.DELETE)
    @ResponseBody
    public SiteResponse duoshan(@RequestParam(value="array1[]", required=true) int array1[],@ModelAttribute Demands demands){
           sid=new int[array1.length];
            for(int i=0;i<array1.length;i++){
               sid[i]=array1[i];
            System.out.println(array1[i]);
        }
//   int i[]={1,2,3,4,5};
//   array1=i;
        return demandsService.duoshan(demands);

    }
    //修改
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public SiteResponse gai(@RequestBody Demands demands){

        return demandsService.gai(demands);

    }
}
