package com.coderpwh.member.application.dto;

import java.util.Date;
import lombok.Data;

/**
 * <p>
 *  DTO出参
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Data
public class MemberPaymentRouterRuleDTO {


    /**
    * 主键id
    */
    private Long id;

    /**
    * 支付方式id
    */
    private Long paymentId;

    /**
    * 收银台支付方式:2、统统付支付宝 3、统统付快捷卡支付 4、微信jsapi 5、支付宝h5 6、微信h5 7、微信小程序
    */
    private String cashierType;

    /**
    * 路由比率：大于0，小于100的整数
    */
    private Integer radio;

    /**
    * 创建人
    */
    private Long createUser;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新人
    */
    private Long updateUser;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 删除标记(0:否 1:是)
    */
    private Integer isDeleted;

    /**
    * 支付渠道中主体的商户号，多个情况使用逗号,隔开
    */
    private String channelMchNo;


}
