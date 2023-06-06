package com.coderpwh.member.domain.model;

import com.coderpwh.member.common.database.PageUtils;

import java.util.List;

import com.coderpwh.member.infrastructure.persistence.entity.MemberPackageDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.member.application.command.MemberPackageQuery;

/**
 * <p>
 * 会员套餐包 仓储类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
public interface MemberPackageRepository extends IService<MemberPackageDO> {

    /**
     * 根据传入的实体内容作为检索条件 进行分页查询
     *
     * @param query 查询对象
     *              pageIndex   起始页
     *              pageSize    每页页数
     * @return 分页结果
     */
    public PageUtils queryPage(MemberPackageQuery query);


    /**
     * 据传入的实体内容作为检索条件 进行查询
     *
     * @param query 领域对象集合
     */
    public List<MemberPackage> queryList(MemberPackageQuery query);

    /**
     * 批量添加
     *
     * @param list 领域对象集合
     * @return 是否执行成功
     */
    boolean saveBatch(List<MemberPackage> list);

    /**
     * 添加一条数据
     *
     * @param memberPackage 领域对象
     * @return 是否执行成功
     */
    boolean save(MemberPackage memberPackage);

    /**
     * 根据id删除
     *
     * @param id id
     * @return 是否执行成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据id修改
     *
     * @param memberPackage 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberPackage memberPackage);

    /**
     * 根据id查询对象
     *
     * @param id id
     * @return 查询后的对象
     */
    MemberPackage getById(Integer id);

    /**
     * 根据ids查询对象集合
     *
     * @param ids ids
     * @return 查询后的对象集合
     */
    List<MemberPackage> getByIds(List<Integer> ids);


    /***
     * 通过租户id与packageCode查询
     * @param tenantId
     * @param packageCode
     * @return
     */
    MemberPackage selectByPackageCode(String tenantId, String packageCode);


    /***
     *通过租户号跟productType查询
     * @param agentNumber
     * @param productType
     * @return
     */
    MemberPackage selectByAgentNumberAndCode(String agentNumber, String productType);


    /***
     *  通过编码与租户id查询
     * @param tenantId
     * @param packageCode
     * @return
     */
    List<MemberPackage> selectByTeantIdAndPackageCode(Long tenantId, String packageCode);

}
