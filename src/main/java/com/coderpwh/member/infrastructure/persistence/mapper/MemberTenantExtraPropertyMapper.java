package com.coderpwh.member.infrastructure.persistence.mapper;

import com.coderpwh.member.domain.model.MemberTenantExtraProperty;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantExtraPropertyDO;
import org.apache.ibatis.annotations.Mapper;
import com.coderpwh.member.application.command.MemberTenantExtraPropertyQuery;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Mapper
public interface MemberTenantExtraPropertyMapper extends BaseMapper<MemberTenantExtraPropertyDO> {

    /**
    * 根据 实体不为空的数据查询
    *
    * @param query 查询对象
    * @return 检索后的集合
    */
    List<MemberTenantExtraProperty> findListByEntity(MemberTenantExtraPropertyQuery query);

}
