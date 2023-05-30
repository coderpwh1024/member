package com.coderpwh.member.infrastructure.persistence.converter;

import org.mapstruct.Mapper;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.infrastructure.persistence.entity.OrderOrderExtraInfoDO;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.domain.model.OrderOrderExtraInfo;

/**
 * <p>
 *  领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderOrderExtraInfoConverter extends MapStructConverter<OrderOrderExtraInfoDO,OrderOrderExtraInfo> {


}
