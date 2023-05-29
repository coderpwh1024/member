package com.coderpwh.member.application.command;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 会员类型下单
 *
 * @author coderpwh
 * @date 2023/5/29 10:54
 */
@Data
public class MemberOrderCommand implements Serializable {


    private String appId;

    private String orderNumber;

    private String orderName;

    private String productType;

    private String productCode;

    private String type;

    private String source;

    private String partnerOrderNumber;

    private String partnerPrice;

    private String payType;

    private String account;

    private String status;

    private String userId;

    private String tenantId;

    private String details;

    private Integer isShareBenefit;

    private Integer accountType;

    private String benefitAccount;

    private String revenue;

    private String category;

    private BigDecimal shareRatio;

    private String cashierType;

    private String returnUrl;

    private String token;

    private String openId;

    private String clientIp;

    private String successfulJumpUrl;

    private String failedJumpUrl;

    private String env;

    private String channelMchNo;

    private String wxAppId;

    private String notifyUrl;


}
