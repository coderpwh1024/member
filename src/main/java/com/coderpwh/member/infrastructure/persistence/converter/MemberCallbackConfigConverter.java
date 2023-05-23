package com.coderpwh.member.infrastructure.persistence.converter;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.model.MemberCallbackConfig;
import org.mapstruct.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCallbackConfigDO;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 回调配置 领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberCallbackConfigConverter extends MapStructConverter<MemberCallbackConfigDO,MemberCallbackConfig> {


}
