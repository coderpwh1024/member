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
 * 退款订单表
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
@Data
@TableName("tb_order_refund_order")
public class RefundOrderDO implements Serializable {

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
     * 订单号
     */
    @TableField("order_number")
    private String orderNumber;

    /**
     * 支付订单号
     */
    @TableField("payment_order_number")
    private String paymentOrderNumber;

    /**
     * 合作方订单号
     */
    @TableField("partner_order_number")
    private String partnerOrderNumber;

    /**
     * 订单名称
     */
    @TableField("name")
    private String name;

    /**
     * 退款状态 pending-处理中 refunding 退款中 refund 已退款 failed 退款失败 closed 退款关闭
     */
    @TableField("refund_status")
    private String refundStatus;

    /**
     * 处理记录 会员（正在注销会员、注销会员失败，请重新确认订单信息、注销会员成功，无需退款、注销会员成功，已退款、注销会员成功，退款失败、注销会员成功，退款关闭） ,权益 （正在注销权益、注销权益失败，注销权益成功，无需退款、注销权益成功，退款中、注销权益成功，已退款、注销权益成功，退款失败、注销权益成功，退款关闭）
     */
    @TableField("record")
    private String record;

    /**
     * 商品类型
     */
    @TableField("product_type")
    private String productType;

    /**
     * 商品编码
     */
    @TableField("product_code")
    private String productCode;

    /**
     * 支付金额 分
     */
    @TableField("money")
    private Integer money;

    /**
     * 退款金额 分
     */
    @TableField("refund_money")
    private Integer refundMoney;

    @TableField("reason")
    private String reason;

    /**
     * 所有成本 分
     */
    @TableField("all_costs")
    private Integer allCosts;

    /**
     * 类型 1-api 2-收银台 3-兑换码
     */
    @TableField("type")
    private Integer type;

    /**
     * 支付方式：1(微信 H5 支付)、2(支付宝 H5 支付)
     */
    @TableField("pay_type")
    private Integer payType;

    /**
     * 订单类别：member-会员订单 benefit-权益订单
     */
    @TableField("category")
    private String category;

    /**
     * 退款时间
     */
    @TableField("refund_time")
    private Date refundTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

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
     * 是否分润(0-否 1-是)
     */
    @TableField("is_share_benefit")
    private Integer isShareBenefit;

    /**
     * 分润账号类型：1-个人 2-商户(默认)
     */
    @TableField("account_type")
    private Integer accountType;

    /**
     * 分润账户
     */
    @TableField("benefit_account")
    private String benefitAccount;

    /**
     * 分润金额
     */
    @TableField("share_money")
    private BigDecimal shareMoney;

    /**
     * 万恒成本
     */
    @TableField("wh_costs")
    private Integer whCosts;

    /**
     * 退款流水号
     */
    @TableField("transaction_id")
    private String transactionId;

    /**
     * 失败原因
     */
    @TableField("failure_reason")
    private String failureReason;


}
