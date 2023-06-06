package com.coderpwh.member.application.assembler.domain;

import com.coderpwh.member.application.dto.BenefitDTO;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.model.MemberPackageBenefitRel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * @author coderpwh
 * @date 2023/6/6 16:02
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BenefitDTOAssembler extends MapStructConverter<BenefitDTO, MemberPackageBenefitRel> {





}
