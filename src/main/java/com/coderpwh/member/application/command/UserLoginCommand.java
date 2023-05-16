package com.coderpwh.member.application.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/5/15 17:55
 */
@Data
public class UserLoginCommand implements Serializable {


    /***
     * 合作方代理号
     */
    @NotBlank(message = "合作方代理不能为空")
    private String agentNumber;


    /**
     * 合作方用户唯有标识
     */
    @NotBlank(message = "合作方唯一标识不能为空")
    private String uniqueId;

    /***
     * 用户手机
     */
    private String phone;

    /***
     * 用户来源
     */
    private String source;


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
