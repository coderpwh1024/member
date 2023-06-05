package com.coderpwh.member.infrastructure.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.coderpwh.member.application.command.OrderOrderExtraInfoQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.OrderOrderExtraInfoDO;
import com.coderpwh.member.domain.model.OrderOrderExtraInfo;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Mapper
public interface OrderOrderExtraInfoMapper extends BaseMapper<OrderOrderExtraInfoDO> {

    /**
     * 根据 实体不为空的数据查询
     *
     * @param query 查询对象
     * @return 检索后的集合
     */
    List<OrderOrderExtraInfo> findListByEntity(OrderOrderExtraInfoQuery query);


    /***
     * 通过订单号与key值查询
     * @param orderNumber
     * @param key
     * @return
     */
    OrderOrderExtraInfoDO selectByOrderNumberAndKey(@Param("orderNumber") String orderNumber, @Param("key") String key);


}
