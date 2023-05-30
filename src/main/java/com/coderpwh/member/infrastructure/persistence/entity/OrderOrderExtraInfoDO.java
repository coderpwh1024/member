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
 * 
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Data
@TableName("tb_order_order_extra_info")
public class OrderOrderExtraInfoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    @TableField("order_number")
    private String orderNumber;

    /**
     * 合作方订单号
     */
    @TableField("partner_order_number")
    private String partnerOrderNumber;

    /**
     * key
     */
    @TableField("key")
    private String key;

    /**
     * value
     */
    @TableField("value")
    private String value;

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
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 更新人
     */
    @TableField("update_user")
    private Long updateUser;

    /**
     * 删除标记(0:否 1:是)
     */
    @TableField("is_deleted")
    private Integer isDeleted;


}
