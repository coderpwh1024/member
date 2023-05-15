package com.coderpwh.member.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coderpwh.member.application.command.CargoBookPageQuery;
import com.coderpwh.member.infrastructure.persistence.entity.CargoBookDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author coderpwh
 * @date 2023/4/27 17:40
 */

@Mapper
public interface CargoBookMapper extends BaseMapper<CargoBookDO> {


    /***
     * 分页查询
     * @param query
     * @return
     */
    List<CargoBookDO> queryByPage(@Param("query") CargoBookPageQuery query);

}
