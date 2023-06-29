package com.coderpwh.member.infrastructure.persistence.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCardHistoryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper
public interface MemberCardHistoryMapper extends BaseMapper<MemberCardHistoryDO> {


    /***
     * 通过user_id查询
     * @param userId
     * @return
     */
    List<MemberCardHistoryDO> getValidOrderByUserId(Long userId);


    /***
     * 通过订单号查询卡历史
     * @param orderNumber
     * @return
     */
    MemberCardHistoryDO selectByOrderNumber(String orderNumber);

    MemberCardHistoryDO selectByOrderNumberOrPatnerOrderNumber(@Param("orderNumber") String orderNumber, @Param("partnerOrderNumber") String partnerOrderNumber);


    /***
     * 通过用户id查询卡历史信息
     * @param userId
     * @return
     */
    List<MemberCardHistoryDO> selectByUserId(Long userId);

}
