package com.coderpwh.member.application.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/5/22 11:36
 */
@Data
public class MemberSaveVO implements Serializable {


    /**
     * 订单号
     */
    private String orderNumber;

    /***
     * 状态
     */
    private String status;

    /***
     * 用户当前会员状态
     */
    private String isMember;

    /***
     *  会员卡类型
     */
    private String cardType;


    /**
     * 会员卡类型中文
     */
    private String cardTypeCn;


    /***
     * 有效期
     */
    private String effectiveTime;


    /***
     *  会员失效期
     */
    private String expirationTime;


    /***
     * 开通异常
     */
    private String errmsg;

}
