package com.coderpwh.member.infrastructure.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author coderpwh
 * @date 2023/4/27 17:07
 */
@Data
@TableName("ddd_cargo")
public class CargoBookDO {

    @TableId(value = "id")
    private String id;

    @TableField("sender_phone")
    private String senderPhone;

    @TableField("description")
    private String description;


    @TableField("originLocation_code")
    private String originlocationCode;

    @TableField("destinationLocation_code")
    private String destinationlocationCode;

    @TableField("created_at")
    private Date createdAt;

    @TableField("updated_at")
    private Date updatedAt;


}
