package com.coderpwh.member.infrastructure.persistence.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.coderpwh.member.infrastructure.persistence.entity.OrderRefundOrderDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.coderpwh.member.application.command.OrderRefundOrderQuery;
import com.coderpwh.member.domain.model.OrderRefundOrder;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
@Mapper
public interface OrderRefundOrderMapper extends BaseMapper<OrderRefundOrderDO> {

    /**
    * 根据 实体不为空的数据查询
    *
    * @param query 查询对象
    * @return 检索后的集合
    */
    List<OrderRefundOrder> findListByEntity(OrderRefundOrderQuery query);

}
