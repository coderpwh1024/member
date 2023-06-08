package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.command.RefundOrderQuery;
import com.coderpwh.member.common.database.PageTransformUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coderpwh.member.domain.model.RefundOrder;
import com.coderpwh.member.domain.model.RefundOrderRepository;

import javax.annotation.Resource;

import com.coderpwh.member.infrastructure.persistence.converter.RefundOrderConverter;
import com.coderpwh.member.infrastructure.persistence.entity.RefundOrderDO;
import com.coderpwh.member.infrastructure.persistence.mapper.RefundOrderMapper;
import com.github.pagehelper.PageHelper;

import java.util.List;

import org.springframework.stereotype.Service;
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
public class RefundOrderRepositoryImpl extends ServiceImpl<RefundOrderMapper, RefundOrderDO> implements RefundOrderRepository {


    @Resource
    private RefundOrderConverter refundOrderConverter;


    @Override
    public boolean saveBatch(List<RefundOrder> list) {
        List<RefundOrderDO> saveList = refundOrderConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(RefundOrder orderRefundOrder) {
        RefundOrderDO saveDO = refundOrderConverter.toDTO(orderRefundOrder);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id) {
        return super.removeById(id);
    }

    @Override
    public boolean updateById(RefundOrder orderRefundOrder) {
        RefundOrderDO updateDO = refundOrderConverter.toDTO(orderRefundOrder);
        return super.updateById(updateDO);
    }

    @Override
    public RefundOrder getById(Integer id) {
        RefundOrderDO entityDO = super.getById(id);
        return refundOrderConverter.toEntity(entityDO);
    }

    @Override
    public List<RefundOrder> getByIds(List<Integer> ids) {
        List<RefundOrderDO> entityList = this.list(Wrappers.<RefundOrderDO>lambdaQuery()
                .in(RefundOrderDO::getId, ids));
        return refundOrderConverter.toEntity(entityList);
    }

}
