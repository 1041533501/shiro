package com.ssh.users.service;

import com.ssh.users.entity.Roles;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
public interface IRolesService extends IService<Roles> {

    Roles SelectRolePer(Integer rid);

}
