package com.coderpwh.member.application.command;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 租户空间 入参
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Data
public class MemberTenantCommand {


    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 租户号
     */
    private Integer agentNumber;

    /**
     * 租户密钥
     */
    private String secret;

    /**
     * 用户卡号前缀
     */
    private String cardPrefix;

    /**
     * 合法权益
     */
    private String legalBenefit;

    /**
     * 续费链接
     */
    private String renewUrl;

    /**
     * 游客链接
     */
    private String visitorUrl;

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

    private String iconImgUrl;

    /**
     * 第三方在线客服url
     */
    private String udeskUrl;


}
