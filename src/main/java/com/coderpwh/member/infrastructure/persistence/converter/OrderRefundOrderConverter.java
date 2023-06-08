package com.coderpwh.member.infrastructure.persistence.converter;

import com.coderpwh.member.infrastructure.persistence.entity.OrderRefundOrderDO;
import org.mapstruct.Mapper;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.domain.model.OrderRefundOrder;

/**
 * <p>
 * 退款订单表 领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderRefundOrderConverter extends MapStructConverter<OrderRefundOrderDO,OrderRefundOrder> {


}
