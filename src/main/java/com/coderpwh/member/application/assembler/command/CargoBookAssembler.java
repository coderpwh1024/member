package com.coderpwh.member.application.assembler.command;

import com.coderpwh.member.application.command.CargoBookCommand;
import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.model.CargoBook;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author coderpwh
 * @date 2023/4/27 16:18
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CargoBookAssembler extends MapStructConverter<CargoBookCommand, CargoBook> {

}
