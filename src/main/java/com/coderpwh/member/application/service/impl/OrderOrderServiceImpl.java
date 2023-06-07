package com.coderpwh.member.application.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

import com.coderpwh.member.application.assembler.vo.OrderInfoAssembler;
import com.coderpwh.member.application.command.OrderInfoQuery;
import com.coderpwh.member.application.command.OrderOrderQuery;
import com.coderpwh.member.application.dto.OrderOrderDTO;
import com.coderpwh.member.application.service.OrderOrderService;
import com.coderpwh.member.application.vo.OrderInfoVO;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.MemberTenantRepository;
import com.coderpwh.member.domain.service.DomainOrderService;
import com.coderpwh.member.domain.specification.OrderInfoSpecification;
import com.coderpwh.member.infrastructure.persistence.mapper.OrderOrderMapper;

import java.util.List;

import cn.hutool.core.collection.CollUtil;
import com.coderpwh.member.application.assembler.command.OrderOrderAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.coderpwh.member.domain.model.OrderOrderRepository;
import com.coderpwh.member.infrastructure.persistence.entity.OrderOrderDO;
import com.coderpwh.member.domain.model.OrderOrder;
import com.coderpwh.member.application.command.OrderOrderCommand;
import com.coderpwh.member.application.assembler.domain.OrderOrderDTOAssembler;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Slf4j
@Service
public class OrderOrderServiceImpl extends ServiceImpl<OrderOrderMapper, OrderOrderDO> implements OrderOrderService {


    @Resource
    private MemberTenantRepository memberTenantRepository;

    @Resource
    private OrderOrderRepository orderOrderRepository;
    @Resource
    private OrderOrderAssembler orderOrderAssembler;
    @Resource
    private OrderOrderDTOAssembler orderOrderDTOAssembler;

    @Resource
    private OrderInfoAssembler orderInfoAssembler;


    @Override
    public PageUtils queryPage(OrderOrderQuery query) {
        // 查询分页数据
        PageUtils pageUtils = orderOrderRepository.queryPage(query);
        List<OrderOrder> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<OrderOrderDTO> dtoList = orderOrderDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(OrderOrderCommand orderOrderCommand) {
        OrderOrder domain = orderOrderAssembler.toEntity(orderOrderCommand);
        return orderOrderRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id) {
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return orderOrderRepository.deleteById(id);
    }

    @Override
    public boolean updateById(OrderOrderCommand orderOrderCommand) {
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (orderOrderCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        OrderOrder domain = orderOrderAssembler.toEntity(orderOrderCommand);
        return orderOrderRepository.updateById(domain);
    }

    @Override
    public OrderOrderDTO getById(Integer id) {
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        OrderOrder domain = orderOrderRepository.getById(id);
        return orderOrderDTOAssembler.toDTO(domain);
    }


    /***
     * 获取订单
     * @param query
     * @return
     */
    @Override
    public OrderInfoVO getOrderInfo(OrderInfoQuery query) {
        log.info("获取订单查询入参为:{}", JSON.toJSONString(query));

        // 校验
        OrderInfoSpecification specification = new OrderInfoSpecification();
        specification.isOrderInfoSpecification(query.getOrderNumber(), query.getPartnerOrderNumber());

        // 领域层
        DomainOrderService domainOrderService = new DomainOrderService(memberTenantRepository, orderOrderRepository, orderInfoAssembler);
        OrderInfoVO orderInfoVO = domainOrderService.getOrderInfo(query);

        return orderInfoVO;
    }


}
