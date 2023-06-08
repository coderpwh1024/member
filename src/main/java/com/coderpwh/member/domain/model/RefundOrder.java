package com.coderpwh.member.domain.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 退款订单表 领域对象
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
@Data
public class RefundOrder {


    private Long id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 支付订单号
     */
    private String paymentOrderNumber;

    /**
     * 合作方订单号
     */
    private String partnerOrderNumber;

    /**
     * 订单名称
     */
    private String name;

    /**
     * 退款状态 pending-处理中 refunding 退款中 refund 已退款 failed 退款失败 closed 退款关闭
     */
    private String refundStatus;

    /**
     * 处理记录 会员（正在注销会员、注销会员失败，请重新确认订单信息、注销会员成功，无需退款、注销会员成功，已退款、注销会员成功，退款失败、注销会员成功，退款关闭） ,权益 （正在注销权益、注销权益失败，注销权益成功，无需退款、注销权益成功，退款中、注销权益成功，已退款、注销权益成功，退款失败、注销权益成功，退款关闭）
     */
    private String record;

    /**
     * 商品类型
     */
    private String productType;

    /**
     * 商品编码
     */
    private String productCode;

    /**
     * 支付金额 分
     */
    private Integer money;

    /**
     * 退款金额 分
     */
    private Integer refundMoney;

    private String reason;

    /**
     * 所有成本 分
     */
    private Integer allCosts;

    /**
     * 类型 1-api 2-收银台 3-兑换码
     */
    private Integer type;

    /**
     * 支付方式：1(微信 H5 支付)、2(支付宝 H5 支付)
     */
    private Integer payType;

    /**
     * 订单类别：member-会员订单 benefit-权益订单
     */
    private String category;

    /**
     * 退款时间
     */
    private Date refundTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改人
     */
    private Long updateUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否已删除(0-否 1-是)
     */
    private Integer isDeleted;

    /**
     * 是否分润(0-否 1-是)
     */
    private Integer isShareBenefit;

    /**
     * 分润账号类型：1-个人 2-商户(默认)
     */
    private Integer accountType;

    /**
     * 分润账户
     */
    private String benefitAccount;

    /**
     * 分润金额
     */
    private BigDecimal shareMoney;

    /**
     * 万恒成本
     */
    private Integer whCosts;

    /**
     * 退款流水号
     */
    private String transactionId;

    /**
     * 失败原因
     */
    private String failureReason;


}
