package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.CargoBookCommand;
import com.coderpwh.member.application.command.CargoBookPageQuery;
import com.coderpwh.member.application.vo.CarGoBookVO;
import com.coderpwh.member.common.database.PageUtils;

/**
 * CarGo
 *
 * @author coderpwh
 * @date 2023/4/27 15:59
 */
public interface CargoService {


    /***
     * 新增
     * @param command
     * @return
     */
    Boolean saveCarGo(CargoBookCommand command);


    /***
     * 查询详情
     * @param senderPhone
     * @return
     */
    CarGoBookVO queryCargoBook(String senderPhone);


    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageUtils queryCargoBookPage(CargoBookPageQuery query);

}
