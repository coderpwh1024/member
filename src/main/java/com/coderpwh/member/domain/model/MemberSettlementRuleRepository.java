package com.coderpwh.member.domain.model;

import java.util.List;
import com.coderpwh.member.infrastructure.persistence.entity.MemberSettlementRuleDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.member.application.command.MemberSettlementRuleQuery;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 结算规则 仓储类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-24
 */
public interface MemberSettlementRuleRepository extends IService<MemberSettlementRuleDO> {

    /**
    * 根据传入的实体内容作为检索条件 进行分页查询
    *
    * @param query 查询对象
    *  pageIndex   起始页
    *  pageSize    每页页数
    * @return 分页结果
    */
    public PageUtils queryPage(MemberSettlementRuleQuery query);


    /**
    * 据传入的实体内容作为检索条件 进行查询
    *
    * @param query 领域对象集合
    */
    public List<MemberSettlementRule> queryList(MemberSettlementRuleQuery query);
    /**
    * 批量添加
    *
    * @param list 领域对象集合
    * @return 是否执行成功
    */
    boolean saveBatch(List<MemberSettlementRule> list);

    /**
    * 添加一条数据
    *
    * @param memberSettlementRule 领域对象
    * @return 是否执行成功
    */
    boolean save(MemberSettlementRule memberSettlementRule);

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
    * @param memberSettlementRule 实体对象
    * @return 是否执行成功
    */
    boolean updateById(MemberSettlementRule memberSettlementRule);

    /**
    * 根据id查询对象
    *
    * @param id id
    * @return 查询后的对象
    */
    MemberSettlementRule getById(Integer id);

    /**
    * 根据ids查询对象集合
    *
    * @param ids ids
    * @return 查询后的对象集合
    */
    List<MemberSettlementRule> getByIds(List<Integer> ids);


}
