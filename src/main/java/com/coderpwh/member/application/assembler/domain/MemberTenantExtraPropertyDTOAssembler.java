package com.coderpwh.member.application.assembler.domain;

import com.coderpwh.member.domain.model.MemberTenantExtraProperty;
import org.mapstruct.Mapper;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.application.dto.MemberTenantExtraPropertyDTO;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 租户额外属性表 领域对象<->dto 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberTenantExtraPropertyDTOAssembler extends MapStructConverter<MemberTenantExtraPropertyDTO,MemberTenantExtraProperty> {


}
