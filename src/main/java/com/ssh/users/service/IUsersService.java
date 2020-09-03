package com.ssh.users.service;

import com.ssh.users.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
public interface IUsersService extends IService<Users> {

    List<Users> selectRole();
    Users selecting(String username);

}
