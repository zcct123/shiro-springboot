package com.zc.shirospringboot.controller;

import com.zc.shirospringboot.model.UserSys;
import com.zc.shirospringboot.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Resource
    UserServiceImpl userService;
    /**
      * @Author: zcct on 2020/9/21 17:02
      * @param:  
      * @return: 
      * @Description:
      */
    @RequestMapping("login")
    public String login(String username,String password)

    {
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);

        try {
            subject.login(usernamePasswordToken);
            log.info("登录成功");
            return "redirect:/index.jsp";

        } catch (UnknownAccountException e) {
            log.info("用户名错误");
        }
        catch (IncorrectCredentialsException e) {
            log.info("密码错误");
        }
        return "redirect:/login.jsp";
    }
    
    /**
      * @Author: zcct on 2020/9/22 9:11
      * @param:  
      * @return: 
      * @Description:
      */
    @RequestMapping("/logout")
    public  String  logout ()
    {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.jsp";
    }

    @RequestMapping("/register")
    public  String  register (String username,String password)
    {
        UserSys userSys = new UserSys();
        userSys.setUsername(username);
        userSys.setPassword(password);
        Integer register = userService.register(userSys);
        if (register>0)
        {
            return "redirect:/login.jsp";

        }else {
            return "redirect:/register.jsp";

        }
    }
}
