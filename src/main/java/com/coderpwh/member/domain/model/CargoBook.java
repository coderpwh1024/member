package com.coderpwh.member.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coderpwh
 * @date 2023/4/27 16:05
 */
@Data
public class CargoBook implements Serializable {


    private String id;


    /***
     *  发送者手机号
     */
    private String senderPhone;

    /***
     * 描述
     */
    private String description;

    /***
     *编码
     */

    private String originlocationCode;

    /**
     * 编码描述
     */
    private String destinationlocationCode;



    private Date createdAt;


    private Date updatedAt;


}
