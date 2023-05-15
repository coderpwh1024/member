package com.coderpwh.member.infrastructure.persistence.converter;


import com.coderpwh.member.common.util.mapstruct.MapStructConverter;
import com.coderpwh.member.domain.model.CargoBook;
import com.coderpwh.member.infrastructure.persistence.entity.CargoBookDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author coderpwh
 * @date 2023/4/27 17:55
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CargoBookConverter extends MapStructConverter<CargoBookDO, CargoBook> {


}
