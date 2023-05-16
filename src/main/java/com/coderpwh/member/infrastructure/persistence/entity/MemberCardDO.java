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
 * 用户卡信息
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Data
@TableName("tb_member_card")
public class MemberCardDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private String tenantId;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 会员卡号
     */
    @TableField("card_number")
    private String cardNumber;

    /**
     * 卡状态：1:active-生效中 2:refund-已退款 3:expired-已过期
     */
    @TableField("status")
    private Integer status;

    /**
     * 卡生效时间
     */
    @TableField("effective_time")
    private Date effectiveTime;

    /**
     * 卡过期时间
     */
    @TableField("expiration_time")
    private Date expirationTime;

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
