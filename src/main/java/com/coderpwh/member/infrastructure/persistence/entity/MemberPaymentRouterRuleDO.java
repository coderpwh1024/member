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
 * 
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Data
@TableName("tb_member_payment_router_rule")
public class MemberPaymentRouterRuleDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 支付方式id
     */
    @TableField("payment_id")
    private Long paymentId;

    /**
     * 收银台支付方式:2、统统付支付宝 3、统统付快捷卡支付 4、微信jsapi 5、支付宝h5 6、微信h5 7、微信小程序
     */
    @TableField("cashier_type")
    private String cashierType;

    /**
     * 路由比率：大于0，小于100的整数
     */
    @TableField("radio")
    private Integer radio;

    /**
     * 创建人
     */
    @TableField("create_user")
    private Long createUser;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新人
     */
    @TableField("update_user")
    private Long updateUser;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 删除标记(0:否 1:是)
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    /**
     * 支付渠道中主体的商户号，多个情况使用逗号,隔开
     */
    @TableField("channel_mch_no")
    private String channelMchNo;


}
