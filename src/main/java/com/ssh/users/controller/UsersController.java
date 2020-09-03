package com.ssh.users.controller;



import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
import com.ssh.users.entity.Roles;
import com.ssh.users.entity.Users;
import com.ssh.users.service.IRolesService;
import com.ssh.users.service.IUsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    private static Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Resource
    private IUsersService iUsersService;

    @Resource
    private IRolesService iRolesService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login1(){
        return "login";
    }

    @RequestMapping(value = "index",method = RequestMethod.POST)
    public String login(String username,String userpwd){


        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,userpwd);
        try {
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException uk){
            logger.error("用户不存在");
            return "redirect:login";
        }catch (IncorrectCredentialsException Il){
            logger.error("用户名或密码错误");
            return "redirect:login";
        }
        return "index";
    }

    @RequestMapping(value = "success",method = RequestMethod.GET)
    public String success(){


        return "success";
    }

    //注册时生成UUID作为用户的盐值
    @RequestMapping(value = "zc",method = RequestMethod.GET)
    public String zhcue(){
        return "zhuce";
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String saveuser(Users users){

        String salt = UUID.randomUUID().toString().replace("-","").replace(",","");
        return "login";
    }

}
