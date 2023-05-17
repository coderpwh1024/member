package com.coderpwh.member.infrastructure.persistence.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coderpwh.member.domain.model.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCardDO;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper
public interface MemberCardMapper extends BaseMapper<MemberCardDO> {


    /***
     * 获取用户卡信息
     * @param userId
     * @return
     */
    UserLogin selectByUserId(Long userId);

}
