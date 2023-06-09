package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.assembler.command.RefundOrderAssembler;
import com.coderpwh.member.application.assembler.domain.RefundOrderDTOAssembler;
import com.coderpwh.member.application.command.RefundOrderQuery;
import com.coderpwh.member.application.dto.RefundOrderDTO;

import javax.annotation.Resource;

import com.coderpwh.member.application.service.RefundOrderService;
import com.coderpwh.member.application.vo.RefundOrderVO;
import com.coderpwh.member.domain.model.RefundOrder;
import com.coderpwh.member.domain.model.RefundOrderRepository;
import com.coderpwh.member.domain.service.DomainRefundOrderService;
import com.coderpwh.member.infrastructure.persistence.entity.RefundOrderDO;
import com.coderpwh.member.infrastructure.persistence.mapper.RefundOrderMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 退款订单表 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
@Service
public class RefundOrderServiceImpl extends ServiceImpl<RefundOrderMapper, RefundOrderDO> implements RefundOrderService {

    @Resource
    private RefundOrderRepository refundOrderRepository;

    @Resource
    private RefundOrderAssembler orderRefundOrderAssembler;

    @Resource
    private RefundOrderDTOAssembler refundOrderDTOAssembler;


    /***
     *查询退款信息
     * @param query
     * @return
     */
    @Override
    public RefundOrderVO getRefundOrderInfo(RefundOrderQuery query) {

        DomainRefundOrderService domain = new DomainRefundOrderService();
        RefundOrderVO refundOrderVO = domain.getRefundOrderInfo(query.getPartnerOrderNumber());


        return refundOrderVO;
    }


}
