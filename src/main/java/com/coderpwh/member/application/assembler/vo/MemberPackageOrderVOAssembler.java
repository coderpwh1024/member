package com.coderpwh.member.application.assembler.vo;

import com.coderpwh.member.application.dto.MemberPackageOrderDTO;
import com.coderpwh.member.application.vo.MemberPackageOrderVO;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author coderpwh
 * @date 2023/6/7 13:42
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberPackageOrderVOAssembler extends MapStructConverter<MemberPackageOrderVO, MemberPackageOrderDTO> {


}
