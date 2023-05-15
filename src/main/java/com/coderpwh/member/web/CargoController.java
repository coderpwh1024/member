package com.coderpwh.member.web;

import com.alibaba.fastjson.JSON;
import com.coderpwh.member.application.command.CarGoBookQuery;
import com.coderpwh.member.application.command.CargoBookCommand;
import com.coderpwh.member.application.command.CargoBookPageQuery;
import com.coderpwh.member.application.service.CargoService;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.common.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author coderpwh
 * @date 2023/4/23 16:09
 */
@Slf4j
@RestController
@RequestMapping("/cargo")
public class CargoController {


    @Resource
    private CargoService cargoService;


    /***
     * 新增
     * @param command
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result saveCarGo(@RequestBody @Valid CargoBookCommand command) {
        log.info("新增入参为:{}", JSON.toJSONString(command));
        Boolean flag = cargoService.saveCarGo(command);
        return Result.update(flag);
    }


    /**
     * 详情查询
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Result queryCargoBook(@RequestBody CarGoBookQuery query) {
        log.info("查询入参为:{}", JSON.toJSONString(query));
        return Result.ok(cargoService.queryCargoBook(query.getSenderPhone()));
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Result queryCargoBookPage(CargoBookPageQuery query) {
        log.info("分页查询入参为:{}", JSON.toJSONString(query));
        PageUtils page = cargoService.queryCargoBookPage(query);
        return Result.ok(page);
    }


}
