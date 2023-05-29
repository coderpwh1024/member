package com.coderpwh.member.domain.model;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.member.application.command.MemberCardQuery;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCardDO;

/**
 * <p>
 * 用户卡信息 仓储类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
public interface MemberCardRepository extends IService<MemberCardDO> {

    /**
     * 根据传入的实体内容作为检索条件 进行分页查询
     *
     * @param query 查询对象
     *              pageIndex   起始页
     *              pageSize    每页页数
     * @return 分页结果
     */
    public PageUtils queryPage(MemberCardQuery query);


    /**
     * 据传入的实体内容作为检索条件 进行查询
     *
     * @param query 领域对象集合
     */
    public List<MemberCard> queryList(MemberCardQuery query);

    /**
     * 批量添加
     *
     * @param list 领域对象集合
     * @return 是否执行成功
     */
    boolean saveBatch(List<MemberCard> list);

    /**
     * 添加一条数据
     *
     * @param memberCard 领域对象
     * @return 是否执行成功
     */
    boolean save(MemberCard memberCard);

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
     * @param memberCard 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberCard memberCard);

    /**
     * 根据id查询对象
     *
     * @param id id
     * @return 查询后的对象
     */
    MemberCard getById(Integer id);

    /**
     * 根据ids查询对象集合
     *
     * @param ids ids
     * @return 查询后的对象集合
     */
    List<MemberCard> getByIds(List<Integer> ids);


    /***
     *  通过用户id查询
     * @param id
     * @return
     */
    UserLogin selectByUserId(Long id);


    /**
     * 根据用户id跟tenantId查询
     *
     * @param userId
     * @param tenantId
     * @return
     */
    MemberCard selectByUserIdAndTenantId(Long userId, String tenantId);


    /***
     * 通过订单号查询卡
     * @param orderNumber
     * @return
     */
    MemberCard selectByOrderNumber(String orderNumber);

}
