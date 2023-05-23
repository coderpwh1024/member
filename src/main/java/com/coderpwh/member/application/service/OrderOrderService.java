package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.OrderOrderQuery;
import com.coderpwh.member.application.dto.OrderOrderDTO;
import com.coderpwh.member.application.command.OrderOrderCommand;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
public interface OrderOrderService {

    /**
    * 根据传入的command作为检索条件 进行分页查询
    *
    * @param query 查询对象
    * @return PageUtils 分页结果
    */
    public PageUtils queryPage(OrderOrderQuery query);


    /**
     * 添加一条数据
     *
     * @param orderOrderCommand 数据对象
     * @return 是否执行成功
     */
    boolean save(OrderOrderCommand orderOrderCommand);

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
     * @param orderOrderCommand 实体对象
     * @return 是否执行成功
     */
    boolean updateById(OrderOrderCommand orderOrderCommand);

     /**
      * 根据id查询对象
      *
      * @param id id
      * @return 查询后的对象
      */
    OrderOrderDTO getById(Integer id);


}
