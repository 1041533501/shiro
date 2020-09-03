package com.ssh.users.mapper;

import com.ssh.users.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {


    List<Users> selectRole();

}
