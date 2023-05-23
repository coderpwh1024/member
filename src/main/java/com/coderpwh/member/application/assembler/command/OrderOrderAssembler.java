package com.coderpwh.member.application.assembler.command;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import com.coderpwh.member.domain.model.OrderOrder;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.application.command.OrderOrderCommand;

/**
 * <p>
 * 订单表 领域对象<->command 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderOrderAssembler extends MapStructConverter<OrderOrderCommand,OrderOrder> {


}
