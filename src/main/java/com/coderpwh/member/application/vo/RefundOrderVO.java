package com.coderpwh.member.application.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/6/8 10:53
 */
@Data
public class RefundOrderVO implements Serializable {


    /***
     * 订单号
     */
    private String orderNumber;


    /***
     * 合作方订单号
     */
    private String partnerOrderNumber;

    /***
     * 退款原因
     */
    private String reason;


    /***
     * 退款状态
     */
    private String stauts;


    /***
     *处理记录
     */
    private String record;

    /***
     * 商品类型
     */
    private String productType;


    /***
     * 商品编码
     */
    private String productCode;


    /***
     * 支付金额(单位:分)
     */
    private String money;


    /***
     * 所有成本(单位:分)
     */
    private String allCosts;


    /**
     * 退款金额(单位:分)
     */
    private String refundMoeny;


    /***
     * 退款时间
     */
    private String refundTime;


    /***
     * 交易流水号
     */
    private String transactionId;

}
