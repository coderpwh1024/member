package com.coderpwh.member.infrastructure.persistence.converter;

import com.coderpwh.member.domain.model.MemberSettlementRule;
import org.mapstruct.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberSettlementRuleDO;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 结算规则 领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-24
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberSettlementRuleConverter extends MapStructConverter<MemberSettlementRuleDO,MemberSettlementRule> {


}
