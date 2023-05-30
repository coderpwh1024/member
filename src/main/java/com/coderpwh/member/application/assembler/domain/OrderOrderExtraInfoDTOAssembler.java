package com.coderpwh.member.application.assembler.domain;

import com.coderpwh.member.application.dto.OrderOrderExtraInfoDTO;
import org.mapstruct.Mapper;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.domain.model.OrderOrderExtraInfo;

/**
 * <p>
 *  领域对象<->dto 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderOrderExtraInfoDTOAssembler extends MapStructConverter<OrderOrderExtraInfoDTO,OrderOrderExtraInfo> {


}
