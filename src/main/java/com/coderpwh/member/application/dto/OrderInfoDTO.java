package com.coderpwh.member.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/6/7 17:25
 */
@Data
public class OrderInfoDTO implements Serializable {


    /***
     * 订单号
     */
    private String orderNumber;

    /***
     * 订单名称
     */
    private String name;

    /***
     * 合作方代理号
     */
    private String partnerOrderNumber;

    /***
     *  订单金额
     */
    private String amount;

    /***
     * 订单状态
     */
    private String orderStatus;

    /***
     * 商品编码
     */
    private String productCode;


    /***
     * 来源
     */
    private String source;


    /***
     * 支付时间
     */
    private String payTime;

    /***
     * 交易流水号
     */
    private String transactionId;


    /***
     * 退款时间
     */
    private String refundTime;


    /***
     * 退款金额
     */
    private String refundMoney;


    /***
     * 权益退款金额
     */
    private String refundBenefitMoney;
}
