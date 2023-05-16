package com.coderpwh.member.domain.model;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 用户卡历史 领域对象
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Data
public class MemberCardHistory {


    private Long id;

    /**
     * 卡ID
     */
    private Long cardId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 卡状态：1:active-生效中 2:wait-待生效 3:refund-已退款 4:expired-已过期
     */
    private Integer status;

    /**
     * 关联订单号
     */
    private String orderNumber;

    /**
     * 合作方订单号
     */
    private String partnerOrderNumber;

    /**
     * 卡类型
     */
    private String cardType;

    /**
     * 卡类型中文
     */
    private String cardTypeCn;

    /**
     * 生效时间
     */
    private Date effectiveTime;

    /**
     * 过期时间
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

    /**
     * 操作描述
     */
    private String operationDescription;


}
