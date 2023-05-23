package com.coderpwh.member.application.assembler.command;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.model.MemberCallbackConfig;
import org.mapstruct.Mapper;
import com.coderpwh.member.application.command.MemberCallbackConfigCommand;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 回调配置 领域对象<->command 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberCallbackConfigAssembler extends MapStructConverter<MemberCallbackConfigCommand,MemberCallbackConfig> {


}
