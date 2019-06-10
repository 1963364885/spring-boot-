package com.AOP;

import com.base.ServiceContain;
import com.pojo.DeleteLog;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class After extends ServiceContain {
    @AfterReturning(returning = "object", value = "execution(* com.mapper.UserMapper.*(..))") //参数指向的文件是下面执行方法的参照
   //拦截删除，把删除数据的id和所需时间存入另一个表
    public void after(Object object) {
        System.out.println();
       DeleteLog deletelog= new DeleteLog();
       int ddid=i[0];
       deletelog.setId(ddid);
       int delid=deletelog.getId();
       String del="删除了id"+delid+"的记录";
       deletelog.setMsg(del);
       delMapper.insertIntoDatabase(deletelog);
    }
}
