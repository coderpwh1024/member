package com.coderpwh.member.application.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/6/8 10:41
 */
@Data
public class RefundOrderQuery implements Serializable {


    /***
     * 合作方订单号
     */
    @NotBlank(message = "合作方订单号不能为空")
    private String partnerOrderNumber;


    /***
     * 合作方代理号
     */
    @NotBlank(message = "合作方代理号不能为空")
    private String agentNumber;


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
