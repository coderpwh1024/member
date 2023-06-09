package com.coderpwh.member.domain.model;

import java.util.List;

import com.coderpwh.member.application.command.RefundOrderQuery;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.infrastructure.persistence.entity.RefundOrderDO;

/**
 * <p>
 * 退款订单表 仓储类
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
public interface RefundOrderRepository extends IService<RefundOrderDO> {


    /**
     * 批量添加
     *
     * @param list 领域对象集合
     * @return 是否执行成功
     */
    boolean saveBatch(List<RefundOrder> list);

    /**
     * 添加一条数据
     *
     * @param orderRefundOrder 领域对象
     * @return 是否执行成功
     */
    boolean save(RefundOrder orderRefundOrder);

    /**
     * 根据id删除
     *
     * @param id id
     * @return 是否执行成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据id修改
     *
     * @param orderRefundOrder 实体对象
     * @return 是否执行成功
     */
    boolean updateById(RefundOrder orderRefundOrder);

    /**
     * 根据id查询对象
     *
     * @param id id
     * @return 查询后的对象
     */
    RefundOrder getById(Integer id);

    /**
     * 根据ids查询对象集合
     *
     * @param ids ids
     * @return 查询后的对象集合
     */
    List<RefundOrder> getByIds(List<Integer> ids);


    /***
     * 通过合作方订单号查询
     * @param partnerOrderNumber
     * @return
     */
    RefundOrder getRefundOrderInfo(String partnerOrderNumber);

}
