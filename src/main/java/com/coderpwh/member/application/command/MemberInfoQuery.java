package com.coderpwh.member.application.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/5/18 10:55
 */
@Data
public class MemberInfoQuery implements Serializable {


    /***
     * 合作方代理号
     */
    @NotBlank(message = "合作方代理号不能为空")
    private String agenutNumber;


    /***
     * 合作方用户id
     */
    @NotBlank(message = "合作方用户id不能为空")
    private String uniqueId;

    /**
     * 时间戳
     */
    @NotBlank(message = "时间戳不能为空")
    private String timestamp;


    /**
     * 签名
     */
    @NotBlank(message = "签名不能为空")
    private String sign;

}
