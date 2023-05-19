package com.coderpwh.member.application.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/5/19 10:16
 */
@Data
public class MemberCheckRenewalVO implements Serializable {


    /***
     *  是否可以续费
     */
    private Boolean isRenewal;
}
