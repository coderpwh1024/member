package com.coderpwh.member.application.assembler.vo;

import com.coderpwh.member.application.dto.RefundOrderDTO;
import com.coderpwh.member.application.vo.RefundOrderVO;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.util.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.Date;
import java.util.Objects;

/**
 * @author coderpwh
 * @date 2023/6/9 11:27
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RefundOrderVOAssebler extends MapStructConverter<RefundOrderVO, RefundOrderDTO> {


    @Override
    @Mapping(source = "refundStatus", target = "status")
    RefundOrderVO toDTO(RefundOrderDTO refundOrderDTO);


    /***
     * 格式转换
     * @param refundTime
     * @return
     */
    default String dateToString(Date refundTime) {
        if (refundTime != null) {
            return DateUtils.getStringByDate(refundTime);
        }
        return null;
    }


}
