package com.coderpwh.member.domain.model;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.member.application.command.MemberCardHistoryQuery;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCardHistoryDO;

/**
 * <p>
 * 用户卡历史 仓储类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
public interface MemberCardHistoryRepository extends IService<MemberCardHistoryDO> {

    /**
     * 根据传入的实体内容作为检索条件 进行分页查询
     *
     * @param query 查询对象
     *              pageIndex   起始页
     *              pageSize    每页页数
     * @return 分页结果
     */
    public PageUtils queryPage(MemberCardHistoryQuery query);


    /**
     * 据传入的实体内容作为检索条件 进行查询
     *
     * @param query 领域对象集合
     */
    public List<MemberCardHistory> queryList(MemberCardHistoryQuery query);

    /**
     * 批量添加
     *
     * @param list 领域对象集合
     * @return 是否执行成功
     */
    boolean saveBatch(List<MemberCardHistory> list);

    /**
     * 添加一条数据
     *
     * @param memberCardHistory 领域对象
     * @return 是否执行成功
     */
    boolean save(MemberCardHistory memberCardHistory);

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
     * @param memberCardHistory 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberCardHistory memberCardHistory);

    /**
     * 根据id查询对象
     *
     * @param id id
     * @return 查询后的对象
     */
    MemberCardHistory getById(Integer id);

    /**
     * 根据ids查询对象集合
     *
     * @param ids ids
     * @return 查询后的对象集合
     */
    List<MemberCardHistory> getByIds(List<Integer> ids);


    /***
     * 通过userId查询
     * @param userId
     * @param orderNumber
     * @return
     */
    List<MemberCardHistory> getLastOrder(Long userId, String orderNumber);


    /***
     * 通过订单号查询
     * @param orderNumber
     * @return
     */
    MemberCardHistory selectByOrderNumber(String orderNumber);

    /***
     * 通过订单号或合作方订单号查询
     * @param orderNumber
     * @param partnerOrderNumber
     * @return
     */
    MemberCardHistory selectByOrderNumberOrPatnerOrderNumber(String orderNumber, String partnerOrderNumber);


    /***
     * 通过userId查询
     * @param userId
     * @return
     */
    List<MemberCardHistory> selectByUserId(Long userId);
}
