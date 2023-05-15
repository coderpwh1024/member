package com.coderpwh.member.application.command;


import com.coderpwh.member.common.database.BasePage;
import lombok.Data;

/**
 * @author coderpwh
 * @date 2023/5/5 10:28
 */

@Data
public class CargoBookPageQuery extends BasePage {

    /**
     * id
     */
    private String id;

    /**
     * 编码
     */
    private String senderPhone;


}
