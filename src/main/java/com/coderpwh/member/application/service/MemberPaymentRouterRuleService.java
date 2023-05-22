package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.MemberPaymentRouterRuleQuery;
import com.coderpwh.member.application.command.MemberPaymentRouterRuleCommand;
import com.coderpwh.member.application.dto.MemberPaymentRouterRuleDTO;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
public interface MemberPaymentRouterRuleService {

    /**
     * 根据传入的command作为检索条件 进行分页查询
     *
     * @param query 查询对象
     * @return PageUtils 分页结果
     */
    public PageUtils queryPage(MemberPaymentRouterRuleQuery query);


    /**
     * 添加一条数据
     *
     * @param memberPaymentRouterRuleCommand 数据对象
     * @return 是否执行成功
     */
    boolean save(MemberPaymentRouterRuleCommand memberPaymentRouterRuleCommand);

    /**
     * 根据id删除
     *
     * @param id id
     * @return 是否执行成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据id修改
     *
     * @param memberPaymentRouterRuleCommand 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberPaymentRouterRuleCommand memberPaymentRouterRuleCommand);

    /**
     * 根据id查询对象
     *
     * @param id id
     * @return 查询后的对象
     */
    MemberPaymentRouterRuleDTO getById(Integer id);


}
