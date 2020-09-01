package com.ssh.users.service.impl;

import com.ssh.users.entity.Roles;
import com.ssh.users.mapper.RolesMapper;
import com.ssh.users.service.IRolesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements IRolesService {

}
