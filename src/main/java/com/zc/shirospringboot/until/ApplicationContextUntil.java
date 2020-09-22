package com.zc.shirospringboot.until;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created bywintec on 2020/9/22
 */
@Component
public class ApplicationContextUntil implements ApplicationContextAware {

    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }


    //传递Bean名字 拿到 userserveice
    public  static  Object getBean (String beanName){
        return  context.getBean(beanName);
    }
}
