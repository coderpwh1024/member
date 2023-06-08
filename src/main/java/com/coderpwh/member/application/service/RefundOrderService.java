package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.RefundOrderQuery;
import com.coderpwh.member.application.dto.RefundOrderDTO;
import com.coderpwh.member.application.vo.RefundOrderVO;

/**
 * <p>
 * 退款订单表 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2023-06-08
 */
public interface RefundOrderService {


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

    /**
     * 根据id查询对象
     *
     * @param id id
     * @return 查询后的对象
     */
    RefundOrderDTO getById(Integer id);


    /***
     * 查询退款订单信息
     * @param query
     * @return
     */
    RefundOrderVO getRefundOrderInfo(RefundOrderQuery query);

}
