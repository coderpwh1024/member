package com.coderpwh.member.infrastructure.persistence.converter;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantDO;
import org.mapstruct.Mapper;
import com.coderpwh.member.domain.model.MemberTenant;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 租户空间 领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberTenantConverter extends MapStructConverter<MemberTenantDO,MemberTenant> {


}
