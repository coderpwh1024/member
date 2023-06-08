package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.assembler.command.OrderRefundOrderAssembler;
import com.coderpwh.member.application.service.OrderRefundOrderService;
import com.coderpwh.member.infrastructure.persistence.entity.OrderRefundOrderDO;
import com.coderpwh.member.application.dto.OrderRefundOrderDTO;
import com.coderpwh.member.application.command.OrderRefundOrderCommand;
import javax.annotation.Resource;
import com.coderpwh.member.application.command.OrderRefundOrderQuery;
import com.coderpwh.member.domain.model.OrderRefundOrderRepository;
import com.coderpwh.member.domain.model.OrderRefundOrder;
import java.util.List;
import com.coderpwh.member.application.assembler.domain.OrderRefundOrderDTOAssembler;
import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.mapper.OrderRefundOrderMapper;
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
public class OrderRefundOrderServiceImpl extends ServiceImpl<OrderRefundOrderMapper, OrderRefundOrderDO> implements OrderRefundOrderService {

    @Resource
    private OrderRefundOrderRepository orderRefundOrderRepository;
    @Resource
    private OrderRefundOrderAssembler orderRefundOrderAssembler;
    @Resource
    private OrderRefundOrderDTOAssembler orderRefundOrderDTOAssembler;



    @Override
    public PageUtils queryPage(OrderRefundOrderQuery query) {
        // 查询分页数据
        PageUtils pageUtils = orderRefundOrderRepository.queryPage(query);
        List<OrderRefundOrder> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<OrderRefundOrderDTO> dtoList = orderRefundOrderDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(OrderRefundOrderCommand orderRefundOrderCommand){
        OrderRefundOrder domain = orderRefundOrderAssembler.toEntity(orderRefundOrderCommand);
        return orderRefundOrderRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return orderRefundOrderRepository.deleteById(id);
    }

    @Override
    public boolean updateById(OrderRefundOrderCommand orderRefundOrderCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (orderRefundOrderCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        OrderRefundOrder domain = orderRefundOrderAssembler.toEntity(orderRefundOrderCommand);
        return orderRefundOrderRepository.updateById(domain);
    }

    @Override
    public OrderRefundOrderDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        OrderRefundOrder domain = orderRefundOrderRepository.getById(id);
        return orderRefundOrderDTOAssembler.toDTO(domain);
    }
}
