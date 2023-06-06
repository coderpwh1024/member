package com.coderpwh.member.application.vo;

import com.coderpwh.member.application.dto.BenefitDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author coderpwh
 * @date 2023/6/6 13:52
 */
@Data
public class MemberPackageDetailVO implements Serializable {


    /**
     * 权益包id
     */
    private Long packageId;

    /**
     * 租户id
     */
    private String tenantId;


    /***
     * 权益包名称
     */
    private String name;


    /***
     * 权益包编码
     */
    private String code;

    /***
     * 有效期计算方式
     */
    private Integer expirationMethod;

    /***
     * 最小续费间隔
     */
    private Integer minRenewalInterval;

    /***
     * 套餐固定天数
     */
    private Integer day;


    /***
     * 价格
     */
    private Integer price;


    /***
     * 市场价格
     */
    private String faceValue;


    /***
     * 权益信息
     */
    private List<BenefitDTO> benefitDTOList;

}
