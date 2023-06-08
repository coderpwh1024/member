package com.coderpwh.member.application.service;

import com.coderpwh.member.application.dto.OrderRefundOrderDTO;
import com.coderpwh.member.application.command.OrderRefundOrderCommand;
import com.coderpwh.member.application.command.OrderRefundOrderQuery;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 退款订单表 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
public interface OrderRefundOrderService {

    /**
    * 根据传入的command作为检索条件 进行分页查询
    *
    * @param query 查询对象
    * @return PageUtils 分页结果
    */
    public PageUtils queryPage(OrderRefundOrderQuery query);


    /**
     * 添加一条数据
     *
     * @param orderRefundOrderCommand 数据对象
     * @return 是否执行成功
     */
    boolean save(OrderRefundOrderCommand orderRefundOrderCommand);

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
     * @param orderRefundOrderCommand 实体对象
     * @return 是否执行成功
     */
    boolean updateById(OrderRefundOrderCommand orderRefundOrderCommand);

     /**
      * 根据id查询对象
      *
      * @param id id
      * @return 查询后的对象
      */
    OrderRefundOrderDTO getById(Integer id);


}
