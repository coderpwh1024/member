package com.coderpwh.member.application.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/5/18 10:59
 */
@Data
public class MemberInfoVO implements Serializable {

    /***
     * 用户id
     */
    private Long userId;

    /***
     * 是否会员
     */
    private Boolean isMember;


    /***
     * 卡类型
     */
    private String cardType;


    /***
     * 卡类型中文
     */
    private String cardTypeCn;


    /***
     * 卡号
     */
    private String cardNumber;


    /***
     *  会员生效时间
     */
    private String effectiveTime;


    /***
     * 会员卡失效时间
     */
    private String expirationTime;
}
