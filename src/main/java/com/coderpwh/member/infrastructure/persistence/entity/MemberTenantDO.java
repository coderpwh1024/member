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
 * 租户空间
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Data
@TableName("tb_member_tenant")
public class MemberTenantDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 编码
     */
    @TableField("code")
    private String code;

    /**
     * 租户号
     */
    @TableField("agent_number")
    private Integer agentNumber;

    /**
     * 租户密钥
     */
    @TableField("secret")
    private String secret;

    /**
     * 用户卡号前缀
     */
    @TableField("card_prefix")
    private String cardPrefix;

    /**
     * 合法权益
     */
    @TableField("legal_benefit")
    private String legalBenefit;

    /**
     * 续费链接
     */
    @TableField("renew_url")
    private String renewUrl;

    /**
     * 游客链接
     */
    @TableField("visitor_url")
    private String visitorUrl;

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
     * 修改人
     */
    @TableField("update_user")
    private Long updateUser;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 是否已删除(0-否 1-是)
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField("icon_img_url")
    private String iconImgUrl;

    /**
     * 第三方在线客服url
     */
    @TableField("udesk_url")
    private String udeskUrl;


}
