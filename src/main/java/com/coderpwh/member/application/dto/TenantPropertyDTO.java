package com.coderpwh.member.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/5/30 15:14
 */
@Data
public class TenantPropertyDTO implements Serializable {

    /***
     * key
     */
    private String codeKey;


    /***
     * value
     */
    private String propertyValue;


}
