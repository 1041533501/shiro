package com.ssh.users.mapper;

import com.ssh.users.entity.Roles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
@Mapper
public interface RolesMapper extends BaseMapper<Roles> {
    List<Roles> SelectRolePer();
}
