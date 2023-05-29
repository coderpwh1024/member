package com.coderpwh.member.application.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "产品类型不能为空")
    private String productType;


    /***
     * 产品编码
     */
    @NotBlank(message = "产品编码不嫩为空")
    private String productCode;


    /***
     * 来源
     */
    private String source;


    /***
     * 合作方订单号
     */
    @NotBlank(message = "合作方订单不能为空")
    private String partnerOrderNumber;

    /***
     *价格
     */
    private String partnerPrice;

    /***
     *  合作方代理号
     */
    @NotBlank(message = "合作方代理号不能为空")
    private String agentNumber;


    /***
     * 回调地址
     */
    private String notifyUrl;


    /**
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
