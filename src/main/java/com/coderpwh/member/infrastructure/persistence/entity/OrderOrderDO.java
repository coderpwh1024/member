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
 * 订单表
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Data
@TableName("tb_order_order")
public class OrderOrderDO implements Serializable {

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
     * 订单名称
     */
    @TableField("name")
    private String name;

    /**
     * 支付状态 unpaid-待支付 canceled-已取消 pending-处理中 confirming-确认中 success-成功 failed-失败 refund-退款 closed-关闭
     */
    @TableField("order_status")
    private String orderStatus;

    /**
     * 金额
     */
    @TableField("amount")
    private Integer amount;

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
     * 订单类型 1-api 2-收银台 3-兑换码
     */
    @TableField("type")
    private Boolean type;

    /**
     * 订单类别：member-会员订单 benefit-权益订单
     */
    @TableField("category")
    private String category;

    /**
     * 下单渠道
     */
    @TableField("source")
    private String source;

    /**
     * 订单详情
     */
    @TableField("details")
    private String details;

    /**
     * 合作方订单号
     */
    @TableField("partner_order_number")
    private String partnerOrderNumber;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 收入
     */
    @TableField("revenue")
    private Integer revenue;

    /**
     * 支付时间
     */
    @TableField("pay_time")
    private Date payTime;

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
     * 业务状态
     */
    @TableField("status")
    private String status;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     *  支付方式:1、微信H5 2、支付宝H5 3、银行卡快捷 4、微信内支付 5、微信小程序支付 6、api 7、兑换码 8、自动续费	
     */
    @TableField("pay_type")
    private Integer payType;

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
     * 支付链接
     */
    @TableField("pay_url")
    private String payUrl;

    /**
     * 分润金额 单位分
     */
    @TableField("share_money")
    private BigDecimal shareMoney;

    /**
     * 支付流水号
     */
    @TableField("transaction_id")
    private String transactionId;

    /**
     * 额外信息
     */
    @TableField("extra_info")
    private String extraInfo;

    /**
     * 是否开启支付中台(1:开启,0:不开启)
     */
    @TableField("is_center_cashier")
    private Boolean isCenterCashier;


}
