package com.coderpwh.member.application.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/6/7 15:48
 */
@Data
public class OrderInfoQuery implements Serializable {


    /***
     * 合作方代理号
     */
    @NotBlank(message = "合作方代理号不能为空")
    private String agentNumber;

    /***
     * 订单号
     */
    private String orderNumber;


    /***
     * 合作方代理号
     */
    private String partnerOrderNumber;

    /***
     * 时间戳
     */
    @NotBlank(message = "时间戳不能为空")
    private String timestamp;

    /***
     *签名
     */
    @NotBlank(message = "签名不能为空")
    private String sign;

}
