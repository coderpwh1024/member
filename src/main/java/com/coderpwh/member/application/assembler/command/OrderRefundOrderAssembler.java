package com.coderpwh.member.application.assembler.command;

import org.mapstruct.Mapper;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.application.command.OrderRefundOrderCommand;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.domain.model.OrderRefundOrder;

/**
 * <p>
 * 退款订单表 领域对象<->command 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderRefundOrderAssembler extends MapStructConverter<OrderRefundOrderCommand,OrderRefundOrder> {


}
