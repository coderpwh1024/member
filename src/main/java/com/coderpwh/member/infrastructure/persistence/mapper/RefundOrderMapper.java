package com.coderpwh.member.infrastructure.persistence.mapper;

import java.util.List;

import com.coderpwh.member.application.command.RefundOrderQuery;
import com.coderpwh.member.domain.model.RefundOrder;
import com.coderpwh.member.infrastructure.persistence.entity.RefundOrderDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
@Mapper
public interface RefundOrderMapper extends BaseMapper<RefundOrderDO> {

    /**
    * 根据 实体不为空的数据查询
    *
    * @param query 查询对象
    * @return 检索后的集合
    */
    List<RefundOrder> findListByEntity(RefundOrderQuery query);

}
