package com.coderpwh.member.domain.specification;

import cn.hutool.core.collection.CollectionUtil;
import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.application.dto.TenantPropertyDTO;
import com.coderpwh.member.common.ddd.AbstractSpecification;
import com.coderpwh.member.common.util.enums.DddEnum;
import com.coderpwh.member.common.util.enums.SysReturnCode;
import com.coderpwh.member.common.util.exception.BusinessException;
import com.coderpwh.member.domain.enums.TenantPropertyKeyConstant;
import com.coderpwh.member.domain.model.*;
import com.coderpwh.member.domain.util.DateUtils;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantExtraInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author coderpwh
 * @date 2023/5/30 11:19
 */
@Slf4j
public class MemberRefundSpecification extends AbstractSpecification<Integer> {


    private OrderOrderRepository orderOrderRepository;


    private MemberCardRepository memberCardRepository;


    private MemberTenantRepository memberTenantRepository;


    private MemberTenantExtraInfoRepository memberTenantExtraInfoRepository;


    private MemberCardHistoryRepository memberCardHistoryRepository;


    public MemberRefundSpecification(OrderOrderRepository orderOrderRepository, MemberCardRepository memberCardRepository) {
        this.orderOrderRepository = orderOrderRepository;
        this.memberCardRepository = memberCardRepository;
    }


    @Override
    public boolean isSatisfiedBy(Integer integer) {
        return false;
    }


    /***
     * 校验用户是否登录
     * @param memberUser
     * @return
     */
    public boolean isUserLogin(MemberUserDTO memberUser) {
        if (Objects.isNull(memberUser)) {
            log.error("当前用户尚未登录");
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前用户尚未登录");
        } else {
            return true;
        }
    }


}
