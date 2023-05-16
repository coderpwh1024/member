package com.coderpwh.member.infrastructure.persistence.converter;


import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import com.coderpwh.member.domain.model.MemberCard;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCardDO;

/**
 * <p>
 * 用户卡信息 领域对象<->实体DO 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberCardConverter extends MapStructConverter<MemberCardDO,MemberCard> {


}
