package com.coderpwh.member.application.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/6/7 10:26
 */
@Data
public class MemberPackageOrderQuery implements Serializable {


    private String uniqueId;

    private String orderNumber;

    private String partnerOrderNumber;

    @NotBlank(message = "合作方代理号不能为空")
    private String agentNumber;

    @NotBlank(message = "时间戳不能为空")
    private String timestamp;

    @NotBlank(message = "签名不能为空")
    private String sign;


}
