package com.coderpwh.member.application.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/5/29 16:39
 */
@Data
public class MemberRefundVO implements Serializable {


    /***
     * 退款订单号
     */
    private String refundOrderNumber;


    /**
     * 订单状态
     */
    private String status;


    /***
     * 是否会员
     */
    private Boolean member;


    /***
     * 会员卡生效时间
     */
    private String cardEffectiveTime;


    /***
     * 会员卡失效时间
     */
    private String cardExpirationTime;


}
