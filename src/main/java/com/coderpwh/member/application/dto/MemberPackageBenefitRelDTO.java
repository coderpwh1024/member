package com.coderpwh.member.application.dto;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 会员套餐权益配比 DTO出参
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Data
public class MemberPackageBenefitRelDTO {


    private Long id;

    /**
    * 租户ID
    */
    private String tenantId;

    /**
    * 权益ID
    */
    private Long benefitId;

    /**
    * 套餐ID
    */
    private Long packageId;

    /**
    * 副标题
    */
    private String subTitle;

    /**
    * 主标题
    */
    private String title;

    /**
    * 开通保留点数
    */
    private Integer reservedPoints;

    /**
    * 开通可用点数
    */
    private Integer availablePoints;

    /**
    * 续费保留点数
    */
    private Integer xfReservedPoints;

    /**
    * 续费可用点数
    */
    private Integer xfAvailablePoints;

    /**
    * 创建人
    */
    private Long createUser;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 是否已删除(0-否 1-是)
    */
    private Integer isDeleted;

    /**
    * 修改人
    */
    private Long updateUser;

    /**
    * 修改时间
    */
    private Date updateTime;


}
