package com.coderpwh.member.infrastructure.persistence.converter;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.OrderOrderDO;
import com.coderpwh.member.domain.model.OrderOrder;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 订单表 领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderOrderConverter extends MapStructConverter<OrderOrderDO,OrderOrder> {


}
