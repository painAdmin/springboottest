package com.springtest.web;

import ch.qos.logback.classic.pattern.EnsureExceptionHandling;
import com.springtest.config.TaskConfiguration;
import com.springtest.outcall.common.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2018/5/25.
 */
@RestController
@RequestMapping("/api")
public class Student implements Teacher {
    private String name;
    @Autowired
    private TaskConfiguration taskExecutor;
    /**
     * 增加新的接口
     */
    @RequestMapping("/index")
    @Override
    public String work() {

        Map<String,Object> param=new HashMap<String,Object>();
        param.put("key","key");
        try {
            Method method=this.getClass().getDeclaredMethod("sysout",Map.class);
            Future<Object> res=AsyncTask.submit(this,method,param);
//            Future<Object> res=()(taskExecutor.getAsyncExecutor()).
            String rr=res.get().toString();
            System.out.println("adfs");
            return rr;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return sysout(param);
    }

    public String sysout(Map<String,Object> param){
        String value = param.get("key").toString();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sys::"+System.currentTimeMillis()+"     "+value);
         return "sys::"+System.currentTimeMillis()+"     "+value;
    }


}
