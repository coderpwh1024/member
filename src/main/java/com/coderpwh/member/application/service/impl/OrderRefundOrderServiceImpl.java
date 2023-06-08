package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.assembler.command.RefundOrderAssembler;
import com.coderpwh.member.application.assembler.domain.RefundOrderDTOAssembler;
import com.coderpwh.member.application.dto.RefundOrderDTO;
import com.coderpwh.member.application.service.OrderRefundOrderService;

import javax.annotation.Resource;

import com.coderpwh.member.domain.model.RefundOrder;
import com.coderpwh.member.domain.model.RefundOrderRepository;
import com.coderpwh.member.infrastructure.persistence.entity.RefundOrderDO;
import com.coderpwh.member.infrastructure.persistence.mapper.RefundOrderMapper;
import org.springframework.stereotype.Service;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 退款订单表 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
@Service
public class OrderRefundOrderServiceImpl extends ServiceImpl<RefundOrderMapper, RefundOrderDO> implements OrderRefundOrderService {

    @Resource
    private RefundOrderRepository orderRefundOrderRepository;
    @Resource
    private RefundOrderAssembler orderRefundOrderAssembler;
    @Resource
    private RefundOrderDTOAssembler refundOrderDTOAssembler;


    @Override
    public boolean deleteById(Integer id) {
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return orderRefundOrderRepository.deleteById(id);
    }


    @Override
    public RefundOrderDTO getById(Integer id) {
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        RefundOrder domain = orderRefundOrderRepository.getById(id);
        return refundOrderDTOAssembler.toDTO(domain);
    }
}
