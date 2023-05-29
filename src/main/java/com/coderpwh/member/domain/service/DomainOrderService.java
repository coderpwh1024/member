package com.coderpwh.member.domain.service;

import com.coderpwh.member.application.command.MemberOrderCommand;
import com.coderpwh.member.domain.model.OrderOrder;
import com.coderpwh.member.domain.model.OrderOrderRepository;
import com.coderpwh.member.infrastructure.persistence.entity.OrderOrderDO;

import java.util.List;

/**
 * 订单领域层
 *
 * @author coderpwh
 * @date 2023/5/23 13:37
 */
public class DomainOrderService {


    private OrderOrderRepository orderOrderRepository;


    /***
     * 会员下单
     */
    public void saveOrderByOrder(MemberOrderCommand command) {

        List<OrderOrder> list = orderOrderRepository.getUnpaidOrder(command.getProductType(), command.getProductCode(), command.getType());

        if (list != null && list.size() > 0) {

        }


    }


}
