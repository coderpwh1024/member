package com.coderpwh.member.domain.model;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.member.application.dto.BenefitDTO;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPackageBenefitRelDO;
import com.coderpwh.member.application.command.MemberPackageBenefitRelQuery;

/**
 * <p>
 * 会员套餐权益配比 仓储类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
public interface MemberPackageBenefitRelRepository extends IService<MemberPackageBenefitRelDO> {

    /**
     * 根据传入的实体内容作为检索条件 进行分页查询
     *
     * @param query 查询对象
     *              pageIndex   起始页
     *              pageSize    每页页数
     * @return 分页结果
     */
    public PageUtils queryPage(MemberPackageBenefitRelQuery query);


    /**
     * 据传入的实体内容作为检索条件 进行查询
     *
     * @param query 领域对象集合
     */
    public List<MemberPackageBenefitRel> queryList(MemberPackageBenefitRelQuery query);

    /**
     * 批量添加
     *
     * @param list 领域对象集合
     * @return 是否执行成功
     */
    boolean saveBatch(List<MemberPackageBenefitRel> list);

    /**
     * 添加一条数据
     *
     * @param memberPackageBenefitRel 领域对象
     * @return 是否执行成功
     */
    boolean save(MemberPackageBenefitRel memberPackageBenefitRel);

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
     * @param memberPackageBenefitRel 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberPackageBenefitRel memberPackageBenefitRel);

    /**
     * 根据id查询对象
     *
     * @param id id
     * @return 查询后的对象
     */
    MemberPackageBenefitRel getById(Integer id);

    /**
     * 根据ids查询对象集合
     *
     * @param ids ids
     * @return 查询后的对象集合
     */
    List<MemberPackageBenefitRel> getByIds(List<Integer> ids);


    /***
     * 根据租户id和packageId查询
     * @param tenantId
     * @param packageId
     * @return
     */
    List<MemberPackageBenefitRel> selectByTenantIdAndPackageId(Long tenantId, Long packageId);


    /**
     * tenantId和packageId查询
     *
     * @param tenantId
     * @param packageId
     * @return
     */
    List<BenefitDTO> getByTenantIdAndPackageId(Long tenantId, Long packageId);

}
