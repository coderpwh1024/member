package com.coderpwh.member.infrastructure.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.experimental.Accessors;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * <p>
 * 回调配置
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Data
@TableName("tb_member_callback_config")
public class MemberCallbackConfigDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private String tenantId;

    /**
     * 类别：member-会员回调 benefit-权益回调 contract -签约回调
     */
    @TableField("category")
    private String category;

    /**
     * 回调地址
     */
    @TableField("callback_url")
    private String callbackUrl;

    /**
     * 合作方秘钥
     */
    @TableField("md5_key")
    private String md5Key;

    /**
     * 超时时间
     */
    @TableField("timeout")
    private Integer timeout;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @TableField("create_user")
    private Long createUser;

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


}
