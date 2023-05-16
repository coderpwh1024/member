package com.coderpwh.member.domain.model;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 用户卡信息 领域对象
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Data
public class MemberCard {


    private Long id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 会员卡号
     */
    private String cardNumber;

    /**
     * 卡状态：1:active-生效中 2:refund-已退款 3:expired-已过期
     */
    private Integer status;

    /**
     * 卡生效时间
     */
    private Date effectiveTime;

    /**
     * 卡过期时间
     */
    private Date expirationTime;

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
