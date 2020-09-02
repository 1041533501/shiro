package com.ssh.users.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 头像
     */
    private String icon;

    /**
     * 住址
     */
    private String address;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 状态
     */
    private String locaed;

    /**
     * 角色
     */
    private List<Roles> roles;


}
