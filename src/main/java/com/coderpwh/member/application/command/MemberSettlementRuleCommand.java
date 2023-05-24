package com.coderpwh.member.application.command;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 结算规则 入参
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-24
 */
@Data
public class MemberSettlementRuleCommand {


    private Long id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 套餐id
     */
    private Long packageId;

    /**
     * 结算方式 1-协议价 2-订单实际成交金额 3-根据套餐匹配
     */
    private Integer rule;

    /**
     * 协议价/套餐价,单位:分
     */
    private Integer price;

    /**
     * 结算比例
     */
    private Float ratio;

    /**
     * 订单来源 0-全部 1-API 2-收银台 3-兑换码
     */
    private Integer orderType;

    /**
     * 是否分润：0-不分润(默认) 1-分润
     */
    private Boolean isShareBenefit;

    /**
     * 账号类型：1-个人 2-商户(默认)
     */
    private Boolean accountType;

    /**
     * 账号
     */
    private String account;

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
     * 分润比例
     */
    private BigDecimal shareRatio;

    /**
     * 支付渠道类型
     */
    private String cashierType;

    private Integer extraPrice;


}
