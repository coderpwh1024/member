package com.coderpwh.member.domain.model;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 租户额外信息表 领域对象
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Data
public class MemberTenantExtraInfo {


    private Integer id;

    /**
     * 额外属性主键
     */
    private Integer extraPropertyId;

    /**
     * 租户 ID
     */
    private String tenantId;

    /**
     * 属性值
     */
    private String propertyValue;

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

    private String remark;


}
