package com.coderpwh.member.application.dto;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 *  DTO出参
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Data
public class OrderOrderExtraInfoDTO {


    /**
    * 主键
    */
    private Long id;

    /**
    * 订单号
    */
    private String orderNumber;

    /**
    * 合作方订单号
    */
    private String partnerOrderNumber;

    /**
    * key
    */
    private String key;

    /**
    * value
    */
    private String value;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 创建人
    */
    private Long createUser;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 更新人
    */
    private Long updateUser;

    /**
    * 删除标记(0:否 1:是)
    */
    private Integer isDeleted;


}
