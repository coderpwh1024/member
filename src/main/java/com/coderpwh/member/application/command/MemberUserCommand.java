package com.coderpwh.member.application.command;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 用户信息 入参
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Data
public class MemberUserCommand {


    private Long id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 第三方唯一ID
     */
    private String uniqueId;

    /**
     * 注册渠道
     */
    private String source;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 激活权益手机号
     */
    private String activationPhone;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否会员 0-false 1-ture
     */
    private Boolean isMember;

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

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 备注
     */
    private String remark;


}
