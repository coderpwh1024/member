package com.coderpwh.member.domain.service;

import com.coderpwh.member.application.assembler.domain.RefundOrderDTOAssembler;
import com.coderpwh.member.application.dto.RefundOrderDTO;
import com.coderpwh.member.application.vo.RefundOrderVO;
import com.coderpwh.member.domain.model.RefundOrder;
import com.coderpwh.member.domain.model.RefundOrderRepository;
import com.coderpwh.member.infrastructure.persistence.entity.RefundOrderDO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author coderpwh
 * @date 2023/6/8 15:12
 */
@Slf4j
public class DomainRefundOrderService {


    private RefundOrderRepository refundOrderRepository;

    private RefundOrderDTOAssembler refundOrderDTOAssembler;




    /***
     *  查询退款订单信息
     * @param partnerOrderNumber
     * @return
     */
    public RefundOrderVO getRefundOrderInfo(String partnerOrderNumber) {
        RefundOrder refundOrder = refundOrderRepository.getRefundOrderInfo(partnerOrderNumber);

        RefundOrderDTO refundOrderDTO = refundOrderDTOAssembler.toDTO(refundOrder);



        return null;
    }

}
