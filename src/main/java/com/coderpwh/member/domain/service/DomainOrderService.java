package com.coderpwh.member.domain.service;

import com.coderpwh.member.application.command.MemberOrderCommand;
import com.coderpwh.member.application.command.OrderInfoQuery;
import com.coderpwh.member.application.dto.OrderInfoDTO;
import com.coderpwh.member.application.vo.MemberOrderVO;
import com.coderpwh.member.application.vo.OrderInfoVO;
import com.coderpwh.member.domain.model.MemberTenant;
import com.coderpwh.member.domain.model.MemberTenantRepository;
import com.coderpwh.member.domain.model.OrderOrder;
import com.coderpwh.member.domain.model.OrderOrderRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 订单领域层
 *
 * @author coderpwh
 * @date 2023/5/23 13:37
 */
@Slf4j
public class DomainOrderService {


    private OrderOrderRepository orderOrderRepository;


    private MemberTenantRepository memberTenantRepository;


    /***
     * 会员下单
     */
    public MemberOrderVO saveOrderByOrder(MemberOrderCommand command) {

        List<OrderOrder> list = orderOrderRepository.getUnpaidOrder(command.getProductType(), command.getProductCode(), command.getType());
        if (list != null && list.size() > 0) {
            //  TODO  返回参数整理
            log.info("当前存在待支付订单,订单号为:{}");
            return null;
        }

        // TODO
        OrderOrder order = new OrderOrder();
        orderOrderRepository.save(order);

        return null;
    }


    /***
     * 订单查询
     * @param query
     * @return
     */
    public OrderInfoVO getOrderInfo(OrderInfoQuery query) {

        MemberTenant memberTenant = memberTenantRepository.selectByAgentNumber(query.getAgentNumber());

        OrderInfoDTO orderInfoDTO = orderOrderRepository.getOrderInfo(memberTenant.getId(), query.getOrderNumber(), query.getPartnerOrderNumber());

        return null;
    }
}
