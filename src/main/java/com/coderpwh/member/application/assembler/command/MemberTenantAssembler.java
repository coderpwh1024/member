package com.coderpwh.member.application.assembler.command;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import com.coderpwh.member.domain.model.MemberTenant;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.application.command.MemberTenantCommand;

/**
 * <p>
 * 租户空间 领域对象<->command 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberTenantAssembler extends MapStructConverter<MemberTenantCommand,MemberTenant> {


}
