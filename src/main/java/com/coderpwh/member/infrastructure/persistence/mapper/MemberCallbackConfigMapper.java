package com.coderpwh.member.infrastructure.persistence.mapper;

import com.coderpwh.member.domain.model.MemberCallbackConfig;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.coderpwh.member.application.command.MemberCallbackConfigQuery;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCallbackConfigDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Mapper
public interface MemberCallbackConfigMapper extends BaseMapper<MemberCallbackConfigDO> {

    /**
    * 根据 实体不为空的数据查询
    *
    * @param query 查询对象
    * @return 检索后的集合
    */
    List<MemberCallbackConfig> findListByEntity(MemberCallbackConfigQuery query);

}
