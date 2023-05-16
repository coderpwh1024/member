package com.coderpwh.member.infrastructure.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Data
@TableName("tb_member_user")
public class MemberUserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private String tenantId;

    /**
     * 第三方唯一ID
     */
    @TableField("unique_id")
    private String uniqueId;

    /**
     * 注册渠道
     */
    @TableField("source")
    private String source;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 激活权益手机号
     */
    @TableField("activation_phone")
    private String activationPhone;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 是否会员 0-false 1-ture
     */
    @TableField("is_member")
    private Boolean isMember;

    /**
     * 修改人
     */
    @TableField("update_user")
    private Long updateUser;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 是否已删除(0-否 1-是)
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    /**
     * 创建人
     */
    @TableField("create_user")
    private Long createUser;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
