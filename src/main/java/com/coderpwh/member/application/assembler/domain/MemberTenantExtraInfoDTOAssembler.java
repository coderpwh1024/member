package com.coderpwh.member.application.assembler.domain;

import org.mapstruct.Mapper;
import com.coderpwh.member.domain.model.MemberTenantExtraInfo;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.application.dto.MemberTenantExtraInfoDTO;

/**
 * <p>
 * 租户额外信息表 领域对象<->dto 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberTenantExtraInfoDTOAssembler extends MapStructConverter<MemberTenantExtraInfoDTO,MemberTenantExtraInfo> {


}
