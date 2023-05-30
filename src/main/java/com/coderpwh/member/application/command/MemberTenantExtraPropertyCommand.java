package com.coderpwh.member.application.command;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 租户额外属性表 入参
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Data
public class MemberTenantExtraPropertyCommand {


    private Integer id;

    /**
     * 额外属性编码
     */
    private String code;

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
