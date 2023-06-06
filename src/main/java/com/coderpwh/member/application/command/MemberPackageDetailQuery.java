package com.coderpwh.member.application.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/6/6 11:21
 */
@Data
public class MemberPackageDetailQuery implements Serializable {

    /***
     * 会员套餐编码
     */
    private String packageCode;


    /***
     * 合作方代理号
     */
    @NotBlank(message = "合作方代理号")
    private String agentNumber;


    /**
     * 时间戳
     */
    @NotBlank(message = "时间戳不能为空")
    private String timestamp;


    /***
     * 签名
     */
    @NotBlank(message = "签名")
    private String sign;

}
