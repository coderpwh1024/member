package com.coderpwh.member.infrastructure.persistence.mapper;

import com.coderpwh.member.domain.model.MemberPackageBenefitRel;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPackageBenefitRelDO;
import com.coderpwh.member.application.command.MemberPackageBenefitRelQuery;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Mapper
public interface MemberPackageBenefitRelMapper extends BaseMapper<MemberPackageBenefitRelDO> {

    /**
    * 根据 实体不为空的数据查询
    *
    * @param query 查询对象
    * @return 检索后的集合
    */
    List<MemberPackageBenefitRel> findListByEntity(MemberPackageBenefitRelQuery query);

}
