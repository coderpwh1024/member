package com.coderpwh.member.application.assembler.command;

import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import org.mapstruct.Mapper;
import com.coderpwh.member.domain.model.MemberPackage;
import org.mapstruct.ReportingPolicy;
import com.coderpwh.member.application.command.MemberPackageCommand;

/**
 * <p>
 * 会员套餐包 领域对象<->command 转换
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberPackageAssembler extends MapStructConverter<MemberPackageCommand,MemberPackage> {


}
