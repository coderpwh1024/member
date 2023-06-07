package com.coderpwh.member.application.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 订单表 DTO出参
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Data
public class OrderOrderDTO {


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
    * 订单名称
    */
    private String name;

    /**
    * 支付状态 unpaid-待支付 canceled-已取消 pending-处理中 confirming-确认中 success-成功 failed-失败 refund-退款 closed-关闭
    */
    private String orderStatus;

    /**
    * 金额
    */
    private Integer amount;

    /**
    * 商品类型
    */
    private String productType;

    /**
    * 商品编码
    */
    private String productCode;

    /**
    * 订单类型 1-api 2-收银台 3-兑换码
    */
    private Boolean type;

    /**
    * 订单类别：member-会员订单 benefit-权益订单
    */
    private String category;

    /**
    * 下单渠道
    */
    private String source;

    /**
    * 订单详情
    */
    private String details;

    /**
    * 合作方订单号
    */
    private String partnerOrderNumber;

    /**
    * 备注
    */
    private String remark;

    /**
    * 收入
    */
    private Integer revenue;

    /**
    * 支付时间
    */
    private Date payTime;

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
    * 业务状态
    */
    private String status;

    /**
    * 修改时间
    */
    private Date updateTime;

    /**
    *  支付方式:1、微信H5 2、支付宝H5 3、银行卡快捷 4、微信内支付 5、微信小程序支付 6、api 7、兑换码 8、自动续费	
    */
    private Integer payType;

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
    * 支付链接
    */
    private String payUrl;

    /**
    * 分润金额 单位分
    */
    private BigDecimal shareMoney;

    /**
    * 支付流水号
    */
    private String transactionId;

    /**
    * 额外信息
    */
    private String extraInfo;

    /**
    * 是否开启支付中台(1:开启,0:不开启)
    */
    private Boolean isCenterCashier;


}
