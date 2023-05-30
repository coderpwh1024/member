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
 * 租户额外属性表
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Data
@TableName("tb_member_tenant_extra_property")
public class MemberTenantExtraPropertyDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 额外属性编码
     */
    @TableField("code")
    private String code;

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
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 更新人
     */
    @TableField("update_user")
    private Long updateUser;

    /**
     * 删除标记(0:否 1:是)
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField("remark")
    private String remark;


}
