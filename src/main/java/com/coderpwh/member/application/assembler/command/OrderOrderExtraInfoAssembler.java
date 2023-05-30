package com.coderpwh.member.application.assembler.command;

import com.coderpwh.member.application.command.OrderOrderExtraInfoCommand;
import org.mapstruct.Mapper;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.domain.model.OrderOrderExtraInfo;

/**
 * <p>
 *  领域对象<->command 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderOrderExtraInfoAssembler extends MapStructConverter<OrderOrderExtraInfoCommand,OrderOrderExtraInfo> {


}
