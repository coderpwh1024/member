package com.coderpwh.member.application.assembler.domain;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import com.coderpwh.member.application.dto.MemberPackageDTO;
import com.coderpwh.member.domain.model.MemberPackage;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 会员套餐包 领域对象<->dto 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberPackageDTOAssembler extends MapStructConverter<MemberPackageDTO,MemberPackage> {


}
