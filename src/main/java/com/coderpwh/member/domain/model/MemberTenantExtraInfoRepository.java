package com.coderpwh.member.domain.model;

import com.coderpwh.member.application.command.MemberTenantExtraInfoQuery;

import java.util.List;

import com.coderpwh.member.application.dto.TenantPropertyDTO;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantExtraInfoDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 租户额外信息表 仓储类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
public interface MemberTenantExtraInfoRepository extends IService<MemberTenantExtraInfoDO> {

    /**
     * 根据传入的实体内容作为检索条件 进行分页查询
     *
     * @param query 查询对象
     *              pageIndex   起始页
     *              pageSize    每页页数
     * @return 分页结果
     */
    public PageUtils queryPage(MemberTenantExtraInfoQuery query);


    /**
     * 据传入的实体内容作为检索条件 进行查询
     *
     * @param query 领域对象集合
     */
    public List<MemberTenantExtraInfo> queryList(MemberTenantExtraInfoQuery query);

    /**
     * 批量添加
     *
     * @param list 领域对象集合
     * @return 是否执行成功
     */
    boolean saveBatch(List<MemberTenantExtraInfo> list);

    /**
     * 添加一条数据
     *
     * @param memberTenantExtraInfo 领域对象
     * @return 是否执行成功
     */
    boolean save(MemberTenantExtraInfo memberTenantExtraInfo);

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
     * @param memberTenantExtraInfo 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberTenantExtraInfo memberTenantExtraInfo);

    /**
     * 根据id查询对象
     *
     * @param id id
     * @return 查询后的对象
     */
    MemberTenantExtraInfo getById(Integer id);

    /**
     * 根据ids查询对象集合
     *
     * @param ids ids
     * @return 查询后的对象集合
     */
    List<MemberTenantExtraInfo> getByIds(List<Integer> ids);


    /***
     * 通过租户id和 key查询
     * @param id
     * @param overdueRefundKey
     * @return
     */
    List<TenantPropertyDTO> selectByTenantId(Long id, String overdueRefundKey);

}
