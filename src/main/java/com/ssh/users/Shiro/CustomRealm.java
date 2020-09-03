package com.ssh.users.Shiro;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ssh.users.controller.UsersController;
import com.ssh.users.entity.Permissions;
import com.ssh.users.entity.Roles;
import com.ssh.users.entity.Users;
import com.ssh.users.mapper.UsersMapper;
import com.ssh.users.service.IUsersService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.Serializable;

public class CustomRealm extends AuthorizingRealm {

    @Resource
    private IUsersService iUsersService;
    
    //实现权限认证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        //根据登录用户名查询数据库
        Users user = iUsersService.getOne((Wrapper<Users>) principalCollection.getPrimaryPrincipal());
        //添加角色权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //查询出当前用户对应的角色  并且将角色添加
        for (Roles role : user.getRoles()) {
            simpleAuthorizationInfo.addRole(role.getRolename());
            //查询出当前角色对应的权限
            for (Permissions permissions:
                 role.getPermissions()) {
                //将对应的权限添加到对应的角色中
                simpleAuthorizationInfo.addStringPermission(permissions.getName());
            }
        }
        //返回填充的数据
        return simpleAuthorizationInfo;
    }

    //实现用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 加这一步的目的是在Post请求的时候会先进认证，然后在到请求  token为空直接不进行下一步
        if(authenticationToken.getPrincipal() == null){
            return null;
        }

        //获取登录用户名
        String username = (String) authenticationToken.getPrincipal();
        //根据登录用户名查询数据库
        Users user = iUsersService.selecting(username);
        if(user == null){
            return null; //如果没有查询到当前用户  返回 用户名或密码错误
        }else {
            ByteSource salt = ByteSource.Util.bytes(user.getSalt());
            // 这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    user, //用户名
                    user.getPassword(), //密码
//                    salt, //加盐的盐值
                    getName()); //realm name
            return simpleAuthenticationInfo;
        }
    }
}
