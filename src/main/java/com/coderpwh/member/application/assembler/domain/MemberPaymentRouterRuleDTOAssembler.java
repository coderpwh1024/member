package com.coderpwh.member.application.assembler.domain;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import com.coderpwh.member.domain.model.MemberPaymentRouterRule;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.application.dto.MemberPaymentRouterRuleDTO;

/**
 * <p>
 *  领域对象<->dto 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberPaymentRouterRuleDTOAssembler extends MapStructConverter<MemberPaymentRouterRuleDTO,MemberPaymentRouterRule> {


}
