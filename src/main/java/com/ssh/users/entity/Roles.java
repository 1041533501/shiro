package com.ssh.users.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_roles")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String rolename;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 状态
     */
    private String available;


}
