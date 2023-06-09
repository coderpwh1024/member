package com.coderpwh.member.application.assembler.vo;

import com.coderpwh.member.application.dto.RefundOrderDTO;
import com.coderpwh.member.application.vo.RefundOrderVO;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * @author coderpwh
 * @date 2023/6/9 11:27
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RefundOrderVOAssebler extends MapStructConverter<RefundOrderVO, RefundOrderDTO> {


    @Override
    @Mapping(source = "refundStatus", target = "status")
    RefundOrderVO toDTO(RefundOrderDTO refundOrderDTO);
}
