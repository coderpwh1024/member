package com.coderpwh.member.infrastructure.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.experimental.Accessors;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 会员套餐包
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Data
@TableName("tb_member_package")
public class MemberPackageDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private String tenantId;

    /**
     * 套餐包中文名称
     */
    @TableField("name")
    private String name;

    /**
     * 套餐包编码
     */
    @TableField("code")
    private String code;

    /**
     * 有效期计算方式：1-叠加固定 2-按自然月算法 3-固定日期
     */
    @TableField("expiration_method")
    private Integer expirationMethod;

    /**
     * 套餐固定天数/固定天数
     */
    @TableField("day")
    private Integer day;

    /**
     * 市场价(单位: 分)
     */
    @TableField("face_value")
    private Integer faceValue;

    /**
     * 售价(单位:分)
     */
    @TableField("price")
    private Integer price;

    /**
     * 最小续费间隔(天)
     */
    @TableField("min_renewal_interval")
    private Integer minRenewalInterval;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @TableField("create_user")
    private Long createUser;

    /**
     * 修改人
     */
    @TableField("update_user")
    private Long updateUser;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 是否已删除(0-否 1-是)
     */
    @TableField("is_deleted")
    private Integer isDeleted;


}
