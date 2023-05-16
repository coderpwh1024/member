package com.coderpwh.member.infrastructure.persistence.converter;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.model.MemberUser;
import org.mapstruct.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberUserDO;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 用户信息 领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberUserConverter extends MapStructConverter<MemberUserDO,MemberUser> {


}
