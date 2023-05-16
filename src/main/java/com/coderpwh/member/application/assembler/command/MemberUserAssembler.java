package com.coderpwh.member.application.assembler.command;


import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.model.MemberUser;
import org.mapstruct.Mapper;
import com.coderpwh.member.application.command.MemberUserCommand;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 用户信息 领域对象<->command 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberUserAssembler extends MapStructConverter<MemberUserCommand,MemberUser> {


}
