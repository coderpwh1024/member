package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.RefundOrderQuery;
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

    /***
     * 查询退款订单信息
     * @param query
     * @return
     */
    RefundOrderVO getRefundOrderInfo(RefundOrderQuery query);

}
