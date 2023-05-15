package com.coderpwh.member.application.command;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/5/4 10:32
 */
@Data
public class CarGoBookQuery implements Serializable {


    /**
     * id
     */
    private String id;


    /**
     * 编码
     */
    @NotBlank(message = "senderPhone")
    private String senderPhone;
}
