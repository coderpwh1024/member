package com.coderpwh.member.infrastructure.persistence.converter;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.model.MemberPackageBenefitRel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPackageBenefitRelDO;

/**
 * <p>
 * 会员套餐权益配比 领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberPackageBenefitRelConverter extends MapStructConverter<MemberPackageBenefitRelDO,MemberPackageBenefitRel> {


}
