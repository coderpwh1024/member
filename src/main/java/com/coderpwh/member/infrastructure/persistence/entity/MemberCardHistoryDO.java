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
 * 用户卡历史
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Data
@TableName("tb_member_card_history")
public class MemberCardHistoryDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 卡ID
     */
    @TableField("card_id")
    private Long cardId;

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
     * 卡状态：1:active-生效中 2:wait-待生效 3:refund-已退款 4:expired-已过期
     */
    @TableField("status")
    private Integer status;

    /**
     * 关联订单号
     */
    @TableField("order_number")
    private String orderNumber;

    /**
     * 合作方订单号
     */
    @TableField("partner_order_number")
    private String partnerOrderNumber;

    /**
     * 卡类型
     */
    @TableField("card_type")
    private String cardType;

    /**
     * 卡类型中文
     */
    @TableField("card_type_cn")
    private String cardTypeCn;

    /**
     * 生效时间
     */
    @TableField("effective_time")
    private Date effectiveTime;

    /**
     * 过期时间
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

    /**
     * 操作描述
     */
    @TableField("operation_description")
    private String operationDescription;


}
