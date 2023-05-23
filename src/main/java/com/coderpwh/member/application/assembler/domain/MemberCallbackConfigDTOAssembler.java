package com.coderpwh.member.application.assembler.domain;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.model.MemberCallbackConfig;
import org.mapstruct.Mapper;
import com.coderpwh.member.application.dto.MemberCallbackConfigDTO;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 回调配置 领域对象<->dto 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberCallbackConfigDTOAssembler extends MapStructConverter<MemberCallbackConfigDTO,MemberCallbackConfig> {


}
