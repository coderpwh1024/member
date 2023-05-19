package com.coderpwh.member.application.service;

import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.application.command.MemberPackageBenefitRelCommand;
import com.coderpwh.member.application.command.MemberPackageBenefitRelQuery;
import com.coderpwh.member.application.dto.MemberPackageBenefitRelDTO;

/**
 * <p>
 * 会员套餐权益配比 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
public interface MemberPackageBenefitRelService {

    /**
    * 根据传入的command作为检索条件 进行分页查询
    *
    * @param query 查询对象
    * @return PageUtils 分页结果
    */
    public PageUtils queryPage(MemberPackageBenefitRelQuery query);


    /**
     * 添加一条数据
     *
     * @param memberPackageBenefitRelCommand 数据对象
     * @return 是否执行成功
     */
    boolean save(MemberPackageBenefitRelCommand memberPackageBenefitRelCommand);

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
     * @param memberPackageBenefitRelCommand 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberPackageBenefitRelCommand memberPackageBenefitRelCommand);

     /**
      * 根据id查询对象
      *
      * @param id id
      * @return 查询后的对象
      */
    MemberPackageBenefitRelDTO getById(Integer id);


}
