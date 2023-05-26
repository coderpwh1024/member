package com.coderpwh.member.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author coderpwh
 * @date 2023/5/26 16:30
 */
@Data
public class MemberSharePriceDTO implements Serializable {


    /**
     * 是否分润：0-不分润(默认) 1-分润
     */
    private Integer isShareBenefit;

    /**
     * 分润比例
     */
    private BigDecimal shareRatio;

    /**
     * 分润账号类型：1-个人 2-商户(默认)
     */
    private Integer accountType;
    /**
     * 分润账号
     */
    private String benefitAccount;
    /**
     * 收入（计算分润）
     */
    private String revenue;


}
