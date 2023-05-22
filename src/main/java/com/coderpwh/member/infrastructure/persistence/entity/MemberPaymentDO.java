package com.coderpwh.member.infrastructure.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 租户支付方式
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Data
@TableName("tb_member_payment")
public class MemberPaymentDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private String tenantId;

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
     * 支付方式:1、微信H5 2、支付宝H5 3、银行卡快捷 4、微信内支付 5、微信小程序支付 6、api 7、兑换码 8、自动续费	
     */
    @TableField("type")
    private Integer type;

    /**
     * 支付环境
     */
    @TableField("env")
    private String env;

    /**
     * 支付提示
     */
    @TableField("tips")
    private String tips;

    /**
     * 展示icon链接
     */
    @TableField("icon_img_url")
    private String iconImgUrl;

    /**
     * 是否展示(0-否 1-是)
     */
    @TableField("is_show")
    private Boolean isShow;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 顺序
     */
    @TableField("rank")
    private Integer rank;

    /**
     * 修改人
     */
    @TableField("update_user")
    private Long updateUser;

    /**
     * 创建人
     */
    @TableField("create_user")
    private Long createUser;

    /**
     * 是否已删除(0-否 1-是)
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 收银台支付方式:2、统统付支付宝 3、统统付快捷卡支付 4、微信jsapi 5、支付宝h5 6、微信h5 7、微信小程序
     */
    @TableField("cashier_type")
    private String cashierType;

    /**
     * 订单类别：member-会员订单, benefit-权益订单,default-全部
     */
    @TableField("category")
    private String category;

    /**
     * 是否开启路由(1:开启,0:不开启)
     */
    @TableField("is_router")
    private Boolean isRouter;

    /**
     * 是否开启支付中台(1:开启,0:不开启)
     */
    @TableField("is_center_cashier")
    private Boolean isCenterCashier;


}
