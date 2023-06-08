package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.common.database.PageTransformUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coderpwh.member.infrastructure.persistence.entity.OrderRefundOrderDO;
import javax.annotation.Resource;
import com.coderpwh.member.application.command.OrderRefundOrderQuery;
import com.github.pagehelper.PageHelper;
import com.coderpwh.member.domain.model.OrderRefundOrderRepository;
import com.coderpwh.member.domain.model.OrderRefundOrder;
import java.io.Serializable;
import java.util.List;
import com.coderpwh.member.infrastructure.persistence.converter.OrderRefundOrderConverter;
import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.mapper.OrderRefundOrderMapper;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 退款订单表 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
@Service
public class OrderRefundOrderRepositoryImpl extends ServiceImpl<OrderRefundOrderMapper, OrderRefundOrderDO> implements OrderRefundOrderRepository {


    @Resource
    private OrderRefundOrderConverter orderRefundOrderConverter;


    @Override
    public PageUtils queryPage(OrderRefundOrderQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<OrderRefundOrderDO> doList = this.list(Wrappers.<OrderRefundOrderDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<OrderRefundOrder> pageList = orderRefundOrderConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }




    @Override
    public List<OrderRefundOrder> queryList(OrderRefundOrderQuery query){
        List<OrderRefundOrderDO> doList = this.list(Wrappers.<OrderRefundOrderDO>lambdaQuery());
        List<OrderRefundOrder> list = orderRefundOrderConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<OrderRefundOrder> list){
        List<OrderRefundOrderDO> saveList = orderRefundOrderConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(OrderRefundOrder orderRefundOrder){
        OrderRefundOrderDO saveDO = orderRefundOrderConverter.toDTO(orderRefundOrder);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id){
        return super.removeById(id);
    }

    @Override
    public boolean updateById(OrderRefundOrder orderRefundOrder){
        OrderRefundOrderDO updateDO = orderRefundOrderConverter.toDTO(orderRefundOrder);
        return super.updateById(updateDO);
    }

    @Override
    public OrderRefundOrder getById(Integer id){
        OrderRefundOrderDO entityDO = super.getById(id);
        return orderRefundOrderConverter.toEntity(entityDO);
    }

    @Override
    public List<OrderRefundOrder> getByIds(List<Integer> ids){
        List<OrderRefundOrderDO> entityList = this.list(Wrappers.<OrderRefundOrderDO>lambdaQuery()
                .in(OrderRefundOrderDO::getId, ids));
        return orderRefundOrderConverter.toEntity(entityList);
    }

}
