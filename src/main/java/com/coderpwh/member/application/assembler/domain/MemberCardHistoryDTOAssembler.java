package com.coderpwh.member.application.assembler.domain;


import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.domain.model.MemberCardHistory;
import com.coderpwh.member.application.dto.MemberCardHistoryDTO;

/**
 * <p>
 * 用户卡历史 领域对象<->dto 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberCardHistoryDTOAssembler extends MapStructConverter<MemberCardHistoryDTO,MemberCardHistory> {


}
