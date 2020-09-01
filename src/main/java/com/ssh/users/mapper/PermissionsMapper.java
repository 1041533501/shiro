package com.ssh.users.mapper;

import com.ssh.users.entity.Permissions;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
@Mapper
public interface PermissionsMapper extends BaseMapper<Permissions> {

}
