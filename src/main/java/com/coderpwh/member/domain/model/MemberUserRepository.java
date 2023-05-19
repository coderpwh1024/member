package com.coderpwh.member.domain.model;


import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.member.application.dto.MemberUserDTO;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.infrastructure.persistence.entity.MemberUserDO;
import com.coderpwh.member.application.command.MemberUserQuery;

/**
 * <p>
 * 用户信息 仓储类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
public interface MemberUserRepository extends IService<MemberUserDO> {

    /**
     * 根据传入的实体内容作为检索条件 进行分页查询
     *
     * @param query 查询对象
     *              pageIndex   起始页
     *              pageSize    每页页数
     * @return 分页结果
     */
    public PageUtils queryPage(MemberUserQuery query);


    /**
     * 据传入的实体内容作为检索条件 进行查询
     *
     * @param query 领域对象集合
     */
    public List<MemberUser> queryList(MemberUserQuery query);

    /**
     * 批量添加
     *
     * @param list 领域对象集合
     * @return 是否执行成功
     */
    boolean saveBatch(List<MemberUser> list);

    /**
     * 添加一条数据
     *
     * @param memberUser 领域对象
     * @return 是否执行成功
     */
    boolean save(MemberUser memberUser);

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
     * @param memberUser 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberUser memberUser);

    /**
     * 根据id查询对象
     *
     * @param id id
     * @return 查询后的对象
     */
    MemberUser getById(Integer id);

    /**
     * 根据ids查询对象集合
     *
     * @param ids ids
     * @return 查询后的对象集合
     */
    List<MemberUser> getByIds(List<Integer> ids);


    /***
     * 通过 uniqueId和tenantId查询
     * @param uniqueId
     * @param tenantId
     * @return
     */
    MemberUser selectByUniqueIdAndTenantId(String uniqueId, Long tenantId);


    /***
     * 通过uniqueId和agentNumber查询
     * @param uniqueId
     * @param agentNumber
     * @return
     */
    MemberUser selectByUniqueIdAndAgentNumber(String uniqueId, String agentNumber);


    /***
     * 通过用户id查询
     * @param userId
     * @return
     */
    MemberUser selectByUserId(Long userId);

}
