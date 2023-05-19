package com.coderpwh.member.application.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author coderpwh
 * @date 2023/5/19 14:14
 */
@Data
public class MemberUserVO implements Serializable {

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
