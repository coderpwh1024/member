package com.coderpwh.member.infrastructure.persistence.converter;

import com.coderpwh.member.domain.model.MemberTenantExtraProperty;
import org.mapstruct.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantExtraPropertyDO;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 租户额外属性表 领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberTenantExtraPropertyConverter extends MapStructConverter<MemberTenantExtraPropertyDO,MemberTenantExtraProperty> {


}
