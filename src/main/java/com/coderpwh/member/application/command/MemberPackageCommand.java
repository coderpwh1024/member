package com.coderpwh.member.application.command;

import java.util.Date;

import lombok.Data;

/**
 * <p>
 * 会员套餐包 入参
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Data
public class MemberPackageCommand {


    private Long id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 套餐包中文名称
     */
    private String name;

    /**
     * 套餐包编码
     */
    private String code;

    /**
     * 有效期计算方式：1-叠加固定 2-按自然月算法 3-固定日期
     */
    private Integer expirationMethod;

    /**
     * 套餐固定天数/固定天数
     */
    private Integer day;

    /**
     * 市场价(单位: 分)
     */
    private Integer faceValue;

    /**
     * 售价(单位:分)
     */
    private Integer price;

    /**
     * 最小续费间隔(天)
     */
    private Integer minRenewalInterval;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改人
     */
    private Long updateUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否已删除(0-否 1-是)
     */
    private Integer isDeleted;


}
