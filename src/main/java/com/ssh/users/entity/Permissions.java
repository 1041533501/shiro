package com.ssh.users.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author ssh
 * @since 2020-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_permissions")
public class Permissions implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 权限路径
     */
    private String url;

    /**
     * 权限类型
     */
    @TableField("TYPE")
    private String type;

    /**
     * 父节点
     */
    private Integer pid;

    /**
     * 状态
     */
    private String available;


}
