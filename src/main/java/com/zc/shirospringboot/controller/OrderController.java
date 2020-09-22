package com.zc.shirospringboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description: OrderController <br>
 * date: 2020/9/22 18:54 <br>
 * author: 19323 <br>
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @RequestMapping("save")
    public  String save() {

        //权限校验

        Subject subject = SecurityUtils.getSubject();
        if(subject.hasRole("admin"))
        {
            System.out.println("保存订单");
        }else {
            System.out.println("没有权限");
        }

        return "redirect:/index.jsp";
    }
    @RequestMapping("save1")
    @RequiresRoles(value ={ "admin","user"}) //用来判断条件   两个代表同时具有
    //@RequiresPermissions("user:*:") //判断权限字符串
    public  String save1() {

        //权限校验
        System.out.println("进入方法");


        return "redirect:/index.jsp";
    }
}
