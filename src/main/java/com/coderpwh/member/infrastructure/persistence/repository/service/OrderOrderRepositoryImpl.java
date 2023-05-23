package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coderpwh.member.application.command.OrderOrderQuery;
import javax.annotation.Resource;

import com.coderpwh.member.common.database.PageTransformUtil;
import com.coderpwh.member.common.database.PageUtils;
import com.github.pagehelper.PageHelper;
import com.coderpwh.member.infrastructure.persistence.mapper.OrderOrderMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import com.coderpwh.member.domain.model.OrderOrderRepository;
import com.coderpwh.member.infrastructure.persistence.converter.OrderOrderConverter;
import com.coderpwh.member.infrastructure.persistence.entity.OrderOrderDO;
import com.coderpwh.member.domain.model.OrderOrder;

/**
 * <p>
 * 订单表 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Service
public class OrderOrderRepositoryImpl extends ServiceImpl<OrderOrderMapper, OrderOrderDO> implements OrderOrderRepository {


    @Resource
    private OrderOrderConverter orderOrderConverter;


    @Override
    public PageUtils queryPage(OrderOrderQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<OrderOrderDO> doList = this.list(Wrappers.<OrderOrderDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<OrderOrder> pageList = orderOrderConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }




    @Override
    public List<OrderOrder> queryList(OrderOrderQuery query){
        List<OrderOrderDO> doList = this.list(Wrappers.<OrderOrderDO>lambdaQuery());
        List<OrderOrder> list = orderOrderConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<OrderOrder> list){
        List<OrderOrderDO> saveList = orderOrderConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(OrderOrder orderOrder){
        OrderOrderDO saveDO = orderOrderConverter.toDTO(orderOrder);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id){
        return super.removeById(id);
    }

    @Override
    public boolean updateById(OrderOrder orderOrder){
        OrderOrderDO updateDO = orderOrderConverter.toDTO(orderOrder);
        return super.updateById(updateDO);
    }

    @Override
    public OrderOrder getById(Integer id){
        OrderOrderDO entityDO = super.getById(id);
        return orderOrderConverter.toEntity(entityDO);
    }

    @Override
    public List<OrderOrder> getByIds(List<Integer> ids){
        List<OrderOrderDO> entityList = this.list(Wrappers.<OrderOrderDO>lambdaQuery()
                .in(OrderOrderDO::getId, ids));
        return orderOrderConverter.toEntity(entityList);
    }

}
