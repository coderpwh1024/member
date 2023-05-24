package com.coderpwh.member.infrastructure.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
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
 * 结算规则
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-24
 */
@Data
@TableName("tb_member_settlement_rule")
public class MemberSettlementRuleDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private String tenantId;

    /**
     * 套餐id
     */
    @TableField("package_id")
    private Long packageId;

    /**
     * 结算方式 1-协议价 2-订单实际成交金额 3-根据套餐匹配
     */
    @TableField("rule")
    private Integer rule;

    /**
     * 协议价/套餐价,单位:分
     */
    @TableField("price")
    private Integer price;

    /**
     * 结算比例
     */
    @TableField("ratio")
    private Float ratio;

    /**
     * 订单来源 0-全部 1-API 2-收银台 3-兑换码
     */
    @TableField("order_type")
    private Integer orderType;

    /**
     * 是否分润：0-不分润(默认) 1-分润
     */
    @TableField("is_share_benefit")
    private Boolean isShareBenefit;

    /**
     * 账号类型：1-个人 2-商户(默认)
     */
    @TableField("account_type")
    private Boolean accountType;

    /**
     * 账号
     */
    @TableField("account")
    private String account;

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
     * 分润比例
     */
    @TableField("share_ratio")
    private BigDecimal shareRatio;

    /**
     * 支付渠道类型
     */
    @TableField("cashier_type")
    private String cashierType;

    @TableField("extra_price")
    private Integer extraPrice;


}
