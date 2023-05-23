package com.coderpwh.member.infrastructure.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.coderpwh.member.domain.model.MemberPackage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPackageDO;
import com.coderpwh.member.application.command.MemberPackageQuery;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Mapper
public interface MemberPackageMapper extends BaseMapper<MemberPackageDO> {

    /**
     * 根据 实体不为空的数据查询
     *
     * @param query 查询对象
     * @return 检索后的集合
     */
    List<MemberPackage> findListByEntity(MemberPackageQuery query);


    /***
     * 通过tenantId与packageCode查询
     * @param tenantId
     * @param packageCode
     * @return
     */
    MemberPackageDO selectByPackageCode(@Param("tenantId") String tenantId, @Param("packageCode") String packageCode);


    /***
     *  通过agentNumber跟productType查询
     * @param agentNumber
     * @param productType
     * @return
     */
    MemberPackageDO selectByAgentNumberAndCode(@Param("agentNumber") String agentNumber, @Param("productType") String productType);


}
