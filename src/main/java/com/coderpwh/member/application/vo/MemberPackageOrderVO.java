package com.coderpwh.member.application.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author coderpwh
 * @date 2023/6/7 10:32
 */
@Data
public class MemberPackageOrderVO implements Serializable {


    /***
     * 用户id
     */
    private Long userId;

    /***
     * 会员卡状态
     */
    private String status;


    /***
     * 会员卡类型
     */
    private String cardType;


    /***
     * 会员卡类型中文
     */
    private String cardTypeCn;


    /***
     * 会员套餐生效时间
     */

    private String effectiveTime;

    /***
     * 会员套餐失效时间
     */
    private String expirationTime;


}
