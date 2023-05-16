package com.coderpwh.member.application.assembler.command;


import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import com.coderpwh.member.application.command.MemberCardHistoryCommand;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.domain.model.MemberCardHistory;

/**
 * <p>
 * 用户卡历史 领域对象<->command 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberCardHistoryAssembler extends MapStructConverter<MemberCardHistoryCommand,MemberCardHistory> {


}
