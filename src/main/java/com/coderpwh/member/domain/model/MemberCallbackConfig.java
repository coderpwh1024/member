package com.coderpwh.member.domain.model;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 回调配置 领域对象
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Data
public class MemberCallbackConfig {


    private Long id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 类别：member-会员回调 benefit-权益回调 contract -签约回调
     */
    private String category;

    /**
     * 回调地址
     */
    private String callbackUrl;

    /**
     * 合作方秘钥
     */
    private String md5Key;

    /**
     * 超时时间
     */
    private Integer timeout;

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
