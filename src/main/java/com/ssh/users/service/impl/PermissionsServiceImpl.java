package com.ssh.users.service.impl;

import com.ssh.users.entity.Permissions;
import com.ssh.users.mapper.PermissionsMapper;
import com.ssh.users.service.IPermissionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
@Service
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions> implements IPermissionsService {

}
