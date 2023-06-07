package com.coderpwh.member.application.vo;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/6/7 10:32
 */
public class MemberPackageOrderVO implements Serializable {


    /***
     * 合作方用户唯一id
     */
    private String uniqueId;

    /**
     * 订单号
     */
    private String orderNumber;


    /***
     * 合作方订单号
     */
    private String partnerOrderNumber;

    /**
     * 合作方代理号
     */
    private String agentNumber;

    /**
     * 时间戳
     */
    private String timestamp;


    /***
     *签名
     */
    private String sign;


}
