package com.coderpwh.member.application.assembler.domain;


import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.model.MemberUser;
import org.mapstruct.Mapper;
import com.coderpwh.member.application.dto.MemberUserDTO;
import org.mapstruct.ReportingPolicy;

/**
 * <p>
 * 用户信息 领域对象<->dto 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberUserDTOAssembler extends MapStructConverter<MemberUserDTO,MemberUser> {


}
