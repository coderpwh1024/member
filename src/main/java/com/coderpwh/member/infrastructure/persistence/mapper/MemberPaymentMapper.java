package com.coderpwh.member.infrastructure.persistence.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPaymentDO;
import com.coderpwh.member.domain.model.MemberPayment;
import com.coderpwh.member.application.command.MemberPaymentQuery;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Mapper
public interface MemberPaymentMapper extends BaseMapper<MemberPaymentDO> {

    /**
     * 根据 实体不为空的数据查询
     *
     * @param query 查询对象
     * @return 检索后的集合
     */
    List<MemberPayment> findListByEntity(MemberPaymentQuery query);


    /***
     *  通过支付方式查询
     * @param tenantId
     * @param payType
     * @param env
     * @param category
     * @return
     */
    MemberPaymentDO selectByPayType(@Param("tenantId") Long tenantId, @Param("payType") String payType, @Param("env") String env, @Param("category") String category);

}
