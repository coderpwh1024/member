package com.coderpwh.member.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coderpwh.member.application.command.MemberPaymentRouterRuleQuery;
import com.coderpwh.member.domain.model.MemberPaymentRouterRule;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPaymentRouterRuleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Mapper
public interface MemberPaymentRouterRuleMapper extends BaseMapper<MemberPaymentRouterRuleDO> {

    /**
     * 根据 实体不为空的数据查询
     *
     * @param query 查询对象
     * @return 检索后的集合
     */
    List<MemberPaymentRouterRule> findListByEntity(MemberPaymentRouterRuleQuery query);



}
