package com.coderpwh.member.application.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coderpwh
 * @date 2023/5/4 10:36
 */
@Data
public class CarGoBookVO implements Serializable {


    private String id;

    private String senderPhone;

    private String description;

    private String originlocationCode;

    private String destinationlocationCode;


    /***
     * 创建时间
     */
    private Date createdAt;

    /***
     * 更新时间
     */
    private Date updatedAt;

}
