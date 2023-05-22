package com.coderpwh.member.infrastructure.persistence.converter;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.model.MemberPaymentRouterRule;
import org.mapstruct.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPaymentRouterRuleDO;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 *  领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberPaymentRouterRuleConverter extends MapStructConverter<MemberPaymentRouterRuleDO, MemberPaymentRouterRule> {


}
