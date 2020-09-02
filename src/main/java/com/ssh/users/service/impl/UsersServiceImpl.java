package com.ssh.users.service.impl;

import com.ssh.users.entity.Users;
import com.ssh.users.mapper.UsersMapper;
import com.ssh.users.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}