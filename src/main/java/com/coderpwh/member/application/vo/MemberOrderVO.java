package com.coderpwh.member.application.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/5/29 13:55
 */
@Data
public class MemberOrderVO implements Serializable {


    /***
     * 订单号
     */
    private String orderNumber;


    /***
     * 订单名称
     */
    private String orderName;


    /**
     * 支付链接
     */
    private String payUrl;


    /***
     * 订单状态
     */
    private String status;


    /***
     *  支付方式
     */
    private String payType;


    /***
     * 订单额外信息
     */
    private String extraInfo;


    /***
     * 交易流水号
     */
    private String transactionId;


}
