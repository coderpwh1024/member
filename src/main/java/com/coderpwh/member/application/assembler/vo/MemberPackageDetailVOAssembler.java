package com.coderpwh.member.application.assembler.vo;

import com.coderpwh.member.application.dto.MemberPackageDTO;
import com.coderpwh.member.application.vo.MemberPackageDetailVO;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author coderpwh
 * @date 2023/6/6 15:32
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberPackageDetailVOAssembler extends MapStructConverter<MemberPackageDetailVO, MemberPackageDTO> {


    @Override
    @Mapping(source = "id", target = "packageId")
    MemberPackageDetailVO toDTO(MemberPackageDTO memberPackageDTO);
}
