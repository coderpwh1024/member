package com.coderpwh.member.application.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/5/29 14:43
 */
@Data
public class MemberRefundCommand implements Serializable {


    /***
     * 订单号
     */
    @NotBlank(message = "订单号不能为空")
    private String orderNumber;


    /***
     * 理由
     */
    @NotBlank(message = "理由不能为空")
    private String reason;


    /**
     * 详情
     */
    private String details;


    /***
     * 合作方订单号
     */
    @NotBlank(message = "租户号不能为空")
    private String agentNumber;


    /***
     * 回调地址
     */
    private String notifyUrl;

    /***
     * 时间戳
     */
    @NotBlank(message = "时间戳不能为空")
    private String timestamp;


    /***
     * 签名
     */
    @NotBlank(message = "签名不能为空")
    private String sign;


}
