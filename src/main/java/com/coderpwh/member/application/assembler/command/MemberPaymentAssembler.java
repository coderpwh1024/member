package com.coderpwh.member.application.assembler.command;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.application.command.MemberPaymentCommand;
import com.coderpwh.member.domain.model.MemberPayment;

/**
 * <p>
 * 租户支付方式 领域对象<->command 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberPaymentAssembler extends MapStructConverter<MemberPaymentCommand,MemberPayment> {


}
