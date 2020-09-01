package com.ssh.users.service.impl;

import com.ssh.users.entity.UserRole;
import com.ssh.users.mapper.UserRoleMapper;
import com.ssh.users.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
