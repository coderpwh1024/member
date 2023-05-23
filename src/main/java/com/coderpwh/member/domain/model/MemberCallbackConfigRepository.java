package com.coderpwh.member.domain.model;

import com.coderpwh.member.common.database.PageUtils;
import java.util.List;
import com.coderpwh.member.application.command.MemberCallbackConfigQuery;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCallbackConfigDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 回调配置 仓储类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
public interface MemberCallbackConfigRepository extends IService<MemberCallbackConfigDO> {

    /**
    * 根据传入的实体内容作为检索条件 进行分页查询
    *
    * @param query 查询对象
    *  pageIndex   起始页
    *  pageSize    每页页数
    * @return 分页结果
    */
    public PageUtils queryPage(MemberCallbackConfigQuery query);


    /**
    * 据传入的实体内容作为检索条件 进行查询
    *
    * @param query 领域对象集合
    */
    public List<MemberCallbackConfig> queryList(MemberCallbackConfigQuery query);
    /**
    * 批量添加
    *
    * @param list 领域对象集合
    * @return 是否执行成功
    */
    boolean saveBatch(List<MemberCallbackConfig> list);

    /**
    * 添加一条数据
    *
    * @param memberCallbackConfig 领域对象
    * @return 是否执行成功
    */
    boolean save(MemberCallbackConfig memberCallbackConfig);

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
    * @param memberCallbackConfig 实体对象
    * @return 是否执行成功
    */
    boolean updateById(MemberCallbackConfig memberCallbackConfig);

    /**
    * 根据id查询对象
    *
    * @param id id
    * @return 查询后的对象
    */
    MemberCallbackConfig getById(Integer id);

    /**
    * 根据ids查询对象集合
    *
    * @param ids ids
    * @return 查询后的对象集合
    */
    List<MemberCallbackConfig> getByIds(List<Integer> ids);


}
