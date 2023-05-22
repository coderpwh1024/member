package com.coderpwh.member.application.assembler.command;

import com.coderpwh.member.application.command.MemberPaymentRouterRuleCommand;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import com.coderpwh.member.domain.model.MemberPaymentRouterRule;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 *  领域对象<->command 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberPaymentRouterRuleAssembler extends MapStructConverter<MemberPaymentRouterRuleCommand,MemberPaymentRouterRule> {


}
