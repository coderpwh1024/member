package com.coderpwh.member.web;

import com.coderpwh.member.application.command.MemberCardHistoryCommand;
import com.coderpwh.member.application.command.MemberCardHistoryQuery;
import com.coderpwh.member.application.service.MemberCardHistoryService;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.common.util.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 用户卡历史 前端控制器
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@RestController
@RequestMapping(value = "/")
public class MemberCardHistoryController {

    @Resource
    private MemberCardHistoryService memberCardHistoryService;

    /**
    * 分页查询
    *
    * @param query 查询对象
    * @return 返回分页格式数据
    */
    @GetMapping(value = "/v1/-page")
    public Result queryTableData(MemberCardHistoryQuery query) {
        // 查询分页数据
        PageUtils page = memberCardHistoryService.queryPage(query);
        return Result.ok(page);
    }


    /**
     * 添加数据
     *
     * @param command 对象
     * @return JSON格式的 对象
     */
    @PostMapping("/v1/")
    public Result add(MemberCardHistoryCommand command) {
        // 添加成功则返回true
        return Result.ok(memberCardHistoryService.save(command));

    }


    /**
     * 修改数据
     *
     * @param command 对象
     * @return JSON格式的 对象
     */
    @PutMapping(value = "/v1/")
    public Result update(MemberCardHistoryCommand command) {
        // 根据id修改，修改成功则返回true
        return Result.ok(memberCardHistoryService.updateById(command));
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return JSON格式的 对象
     */
    @DeleteMapping(value = "/v1//{id}")
    public Result deleteById(@PathVariable Integer id) {
        // 根据id删除，删除成功则返回true
        return Result.ok(memberCardHistoryService.deleteById(id));
    }

    /**
     * 根据传入id获取单个对象
     *
     * @param id id
     * @return JSON格式的 对象
     */
    @PostMapping(value = "/v1//{id}")
    public Result getById(@PathVariable Integer id) {
        return Result.ok(memberCardHistoryService.getById(id));
    }

}
