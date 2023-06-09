package com.coderpwh.member.domain.service;

import com.coderpwh.member.application.assembler.domain.RefundOrderDTOAssembler;
import com.coderpwh.member.application.assembler.vo.RefundOrderVOAssebler;
import com.coderpwh.member.application.dto.RefundOrderDTO;
import com.coderpwh.member.application.vo.RefundOrderVO;
import com.coderpwh.member.domain.model.RefundOrder;
import com.coderpwh.member.domain.model.RefundOrderRepository;
import com.coderpwh.member.domain.util.DateUtils;
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


    private RefundOrderVOAssebler refundOrderVOAssebler;


    public DomainRefundOrderService(RefundOrderRepository refundOrderRepository, RefundOrderDTOAssembler refundOrderDTOAssembler, RefundOrderVOAssebler refundOrderVOAssebler) {
        this.refundOrderRepository = refundOrderRepository;
        this.refundOrderDTOAssembler = refundOrderDTOAssembler;
        this.refundOrderVOAssebler = refundOrderVOAssebler;
    }


    /***
     *  查询退款订单信息
     * @param partnerOrderNumber
     * @return
     */
    public RefundOrderVO getRefundOrderInfo(String partnerOrderNumber) {
        RefundOrder refundOrder = refundOrderRepository.getRefundOrderInfo(partnerOrderNumber);

        RefundOrderDTO refundOrderDTO = refundOrderDTOAssembler.toDTO(refundOrder);
        RefundOrderVO refundOrderVO = refundOrderVOAssebler.toDTO(refundOrderDTO);
        refundOrderVO.setRefundTime(DateUtils.getStringByDate(refundOrderDTO.getRefundTime()));
        return refundOrderVO;
    }

}
