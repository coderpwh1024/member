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
 * 会员套餐权益配比
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Data
@TableName("tb_member_package_benefit_rel")
public class MemberPackageBenefitRelDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private String tenantId;

    /**
     * 权益ID
     */
    @TableField("benefit_id")
    private Long benefitId;

    /**
     * 套餐ID
     */
    @TableField("package_id")
    private Long packageId;

    /**
     * 副标题
     */
    @TableField("sub_title")
    private String subTitle;

    /**
     * 主标题
     */
    @TableField("title")
    private String title;

    /**
     * 开通保留点数
     */
    @TableField("reserved_points")
    private Integer reservedPoints;

    /**
     * 开通可用点数
     */
    @TableField("available_points")
    private Integer availablePoints;

    /**
     * 续费保留点数
     */
    @TableField("xf_reserved_points")
    private Integer xfReservedPoints;

    /**
     * 续费可用点数
     */
    @TableField("xf_available_points")
    private Integer xfAvailablePoints;

    /**
     * 创建人
     */
    @TableField("create_user")
    private Long createUser;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 是否已删除(0-否 1-是)
     */
    @TableField("is_deleted")
    private Integer isDeleted;

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


}
