package com.coderpwh.member.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberUserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper
public interface MemberUserMapper extends BaseMapper<MemberUserDO> {


    /***
     * 通过租户id和外部id查询
     * @param uniqueId
     * @param tenantId
     * @return
     */
    MemberUserDO selectByUniqueIdAndTenantId(@Param("uniqueId") String uniqueId, @Param("tenantId") Long tenantId);
}
