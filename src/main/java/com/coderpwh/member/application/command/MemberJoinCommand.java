package com.coderpwh.member.application.command;

import lombok.Data;

import java.io.Serializable;

/**
 * 开通会员参数
 *
 * @author coderpwh
 * @date 2023/5/22 10:10
 */
@Data
public class MemberJoinCommand implements Serializable {


    /***
     *  产品类型
     */
    private String productType;


    /***
     * 产品编码
     */
    private String productCode;


    /***
     * 来源
     */
    private String source;


    /***
     * 合作方订单号
     */
    private String partnerOrderNumber;

    /***
     *价格
     */
    private String partnerPrice;

    /***
     *  合作方代理号
     */
    private String agentNumber;


    /***
     * 回调地址
     */
    private String notifyUrl;


    /**
     * 时间戳
     */
    private String timestamp;


    /***
     * 签名
     */
    private String sign;
}
