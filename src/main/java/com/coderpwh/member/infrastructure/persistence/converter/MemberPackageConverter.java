package com.coderpwh.member.infrastructure.persistence.converter;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import com.coderpwh.member.domain.model.MemberPackage;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPackageDO;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 会员套餐包 领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberPackageConverter extends MapStructConverter<MemberPackageDO,MemberPackage> {


}
