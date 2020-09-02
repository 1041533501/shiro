package com.ssh.users.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ssh.users.entity.Users;
import com.ssh.users.service.IUsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private IUsersService iUsersService;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String login(){
//        List<Users> list = iUsersService.list();
//        list.forEach(System.out :: println);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("Username","admin");
        Users u = new Users();
        u.setUsername("admin");
        Users one = iUsersService.getOne(queryWrapper);
        System.out.println(one);
        return "index";
    }

}
