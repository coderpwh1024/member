package com.coderpwh.member.application.assembler.domain;


import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import com.coderpwh.member.domain.model.MemberCard;
import com.coderpwh.member.application.dto.MemberCardDTO;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 用户卡信息 领域对象<->dto 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberCardDTOAssembler extends MapStructConverter<MemberCardDTO,MemberCard> {


}
