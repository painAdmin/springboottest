package com.springtest.outcall.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Future;


/**
 * Created by Administrator on 2018/5/25.
 */

@Component
public class AsyncTask {

    public static final Logger loggger= LoggerFactory.getLogger(AsyncTask.class);

    @Async
    public static Future<Object> submit(Object object, Method method , Map<String,Object> params) throws Exception {
        method.setAccessible(true);
        Object res=method.invoke(object,params);
        return new AsyncResult<>(res);
    }
}
