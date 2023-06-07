package com.coderpwh.member.application.assembler.vo;

import com.coderpwh.member.application.dto.OrderInfoDTO;
import com.coderpwh.member.application.vo.OrderInfoVO;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * @author coderpwh
 * @date 2023/6/7 19:07
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderInfoAssembler extends MapStructConverter<OrderInfoVO, OrderInfoDTO> {


    @Override
    @Mapping(source = "amount", target = "money")
    @Mapping(source = "name", target = "orderName")
    @Mapping(source = "orderStatus", target = "status")
    OrderInfoVO toDTO(OrderInfoDTO orderInfoDTO);
}
