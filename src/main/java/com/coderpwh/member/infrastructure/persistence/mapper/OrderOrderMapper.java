package com.coderpwh.member.infrastructure.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.OrderOrderDO;
import com.coderpwh.member.domain.model.OrderOrder;
import com.coderpwh.member.application.command.OrderOrderQuery;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Mapper
public interface OrderOrderMapper extends BaseMapper<OrderOrderDO> {

    /**
     * 根据 实体不为空的数据查询
     *
     * @param query 查询对象
     * @return 检索后的集合
     */
    List<OrderOrder> findListByEntity(OrderOrderQuery query);


    /***
     *  获取待支付订单
     * @param productCode
     * @param productType
     * @param type
     * @return
     */
    List<OrderOrderDO> getUnpaidOrder(@Param("productCode") String productCode, @Param("productType") String productType, @Param("type") String type);


    /***
     *  通过合作方订单号查询
     * @param partnerOrderNumber
     * @return
     */
    OrderOrderDO selectByPartnerOrderNumber(@Param("partnerOrderNumber") String partnerOrderNumber);


    /***
     * 通过订单号查询
     * @param orderNumber
     * @return
     */
    OrderOrderDO selectByOrderNumber(@Param("orderNumber") String orderNumber);

}
