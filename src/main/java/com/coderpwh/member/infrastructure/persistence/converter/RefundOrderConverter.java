package com.coderpwh.member.infrastructure.persistence.converter;

import com.coderpwh.member.domain.model.RefundOrder;
import com.coderpwh.member.infrastructure.persistence.entity.RefundOrderDO;
import org.mapstruct.Mapper;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 退款订单表 领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RefundOrderConverter extends MapStructConverter<RefundOrderDO, RefundOrder> {


}
