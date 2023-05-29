package com.coderpwh.member.domain.model;

import java.util.List;

import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.infrastructure.persistence.entity.OrderOrderDO;
import com.coderpwh.member.application.command.OrderOrderQuery;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单表 仓储类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
public interface OrderOrderRepository extends IService<OrderOrderDO> {

    /**
     * 根据传入的实体内容作为检索条件 进行分页查询
     *
     * @param query 查询对象
     *              pageIndex   起始页
     *              pageSize    每页页数
     * @return 分页结果
     */
    public PageUtils queryPage(OrderOrderQuery query);


    /**
     * 据传入的实体内容作为检索条件 进行查询
     *
     * @param query 领域对象集合
     */
    public List<OrderOrder> queryList(OrderOrderQuery query);

    /**
     * 批量添加
     *
     * @param list 领域对象集合
     * @return 是否执行成功
     */
    boolean saveBatch(List<OrderOrder> list);

    /**
     * 添加一条数据
     *
     * @param orderOrder 领域对象
     * @return 是否执行成功
     */
    boolean save(OrderOrder orderOrder);

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
     * @param orderOrder 实体对象
     * @return 是否执行成功
     */
    boolean updateById(OrderOrder orderOrder);

    /**
     * 根据id查询对象
     *
     * @param id id
     * @return 查询后的对象
     */
    OrderOrder getById(Integer id);

    /**
     * 根据ids查询对象集合
     *
     * @param ids ids
     * @return 查询后的对象集合
     */
    List<OrderOrder> getByIds(List<Integer> ids);


    List<OrderOrder> getUnpaidOrder(String productType, String productCode, String type);


    /***
     *  通过合作方订单号查询
     * @param partnerOrderNumber
     * @return
     */
    OrderOrder selectByPartnerOrderNumber(String partnerOrderNumber);


    /***
     * 通过订单号查询
     * @param orderNumber
     * @return
     */
    OrderOrder selectByOrderNumber(String orderNumber);

}
