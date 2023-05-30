package com.coderpwh.member.domain.model;

import java.util.List;
import com.coderpwh.member.application.command.OrderOrderExtraInfoQuery;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coderpwh.member.infrastructure.persistence.entity.OrderOrderExtraInfoDO;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 *  仓储类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
public interface OrderOrderExtraInfoRepository extends IService<OrderOrderExtraInfoDO> {

    /**
    * 根据传入的实体内容作为检索条件 进行分页查询
    *
    * @param query 查询对象
    *  pageIndex   起始页
    *  pageSize    每页页数
    * @return 分页结果
    */
    public PageUtils queryPage(OrderOrderExtraInfoQuery query);


    /**
    * 据传入的实体内容作为检索条件 进行查询
    *
    * @param query 领域对象集合
    */
    public List<OrderOrderExtraInfo> queryList(OrderOrderExtraInfoQuery query);
    /**
    * 批量添加
    *
    * @param list 领域对象集合
    * @return 是否执行成功
    */
    boolean saveBatch(List<OrderOrderExtraInfo> list);

    /**
    * 添加一条数据
    *
    * @param orderOrderExtraInfo 领域对象
    * @return 是否执行成功
    */
    boolean save(OrderOrderExtraInfo orderOrderExtraInfo);

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
    * @param orderOrderExtraInfo 实体对象
    * @return 是否执行成功
    */
    boolean updateById(OrderOrderExtraInfo orderOrderExtraInfo);

    /**
    * 根据id查询对象
    *
    * @param id id
    * @return 查询后的对象
    */
    OrderOrderExtraInfo getById(Integer id);

    /**
    * 根据ids查询对象集合
    *
    * @param ids ids
    * @return 查询后的对象集合
    */
    List<OrderOrderExtraInfo> getByIds(List<Integer> ids);


}
