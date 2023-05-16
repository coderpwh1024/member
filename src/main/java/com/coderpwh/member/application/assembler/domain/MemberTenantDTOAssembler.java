package com.coderpwh.member.application.assembler.domain;


import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import com.coderpwh.member.domain.model.MemberTenant;
import com.coderpwh.member.application.dto.MemberTenantDTO;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 租户空间 领域对象<->dto 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberTenantDTOAssembler extends MapStructConverter<MemberTenantDTO,MemberTenant> {


}
