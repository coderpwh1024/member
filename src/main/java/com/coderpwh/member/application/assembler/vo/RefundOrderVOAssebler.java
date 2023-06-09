package com.coderpwh.member.application.assembler.vo;

import com.coderpwh.member.application.dto.RefundOrderDTO;
import com.coderpwh.member.application.vo.RefundOrderVO;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.enums.RefundStatusEnum;
import com.coderpwh.member.domain.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.Date;

/**
 * @author coderpwh
 * @date 2023/6/9 11:27
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RefundOrderVOAssebler extends MapStructConverter<RefundOrderVO, RefundOrderDTO> {


    @Override
    @Mapping(source = "refundStatus", target = "status")
    @Mapping(source = "refundStatus", target = "statusDesc")
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

    /***
     * 状态扭转
     * @param refundStatus
     * @return
     */
    default String getStatusDesc(String refundStatus) {
        System.out.println("转态:" + refundStatus);
        if (StringUtils.isNotBlank(refundStatus)) {
            return RefundStatusEnum.getStatusDesc(refundStatus);
        } else {
            return refundStatus;
        }
    }

}
