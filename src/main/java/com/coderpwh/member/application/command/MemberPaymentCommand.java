package com.coderpwh.member.application.command;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 * 租户支付方式 入参
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Data
public class MemberPaymentCommand {


    private Long id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 支付方式:1、微信H5 2、支付宝H5 3、银行卡快捷 4、微信内支付 5、微信小程序支付 6、api 7、兑换码 8、自动续费	
     */
    private Integer type;

    /**
     * 支付环境
     */
    private String env;

    /**
     * 支付提示
     */
    private String tips;

    /**
     * 展示icon链接
     */
    private String iconImgUrl;

    /**
     * 是否展示(0-否 1-是)
     */
    private Boolean isShow;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 顺序
     */
    private Integer rank;

    /**
     * 修改人
     */
    private Long updateUser;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 是否已删除(0-否 1-是)
     */
    private Integer isDeleted;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 收银台支付方式:2、统统付支付宝 3、统统付快捷卡支付 4、微信jsapi 5、支付宝h5 6、微信h5 7、微信小程序
     */
    private String cashierType;

    /**
     * 订单类别：member-会员订单, benefit-权益订单,default-全部
     */
    private String category;

    /**
     * 是否开启路由(1:开启,0:不开启)
     */
    private Boolean isRouter;

    /**
     * 是否开启支付中台(1:开启,0:不开启)
     */
    private Boolean isCenterCashier;


}
