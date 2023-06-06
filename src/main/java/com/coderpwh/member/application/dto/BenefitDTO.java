package com.coderpwh.member.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/6/6 14:54
 */
@Data
public class BenefitDTO implements Serializable {


    /***
     * 权益名称
     */
    private String benefitName;


    /***
     * 权益编码
     */
    private String benefitCode;


    /**
     * 总点位
     */
    private Integer totalPoints;

}
