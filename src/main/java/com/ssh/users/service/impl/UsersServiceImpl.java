package com.ssh.users.service.impl;

import com.ssh.users.entity.Users;
import com.ssh.users.mapper.UsersMapper;
import com.ssh.users.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private UsersMapper usersMapper;

    @Override
    public List<Users> selectRole() {
        return usersMapper.selectRole();
    }

    @Override
    public Users selecting(String username) {
        return usersMapper.selecting(username);
    }
}
