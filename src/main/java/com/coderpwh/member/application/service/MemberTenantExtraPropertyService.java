package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.MemberTenantExtraPropertyCommand;
import com.coderpwh.member.application.dto.MemberTenantExtraPropertyDTO;
import com.coderpwh.member.application.command.MemberTenantExtraPropertyQuery;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 租户额外属性表 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
public interface MemberTenantExtraPropertyService {

    /**
    * 根据传入的command作为检索条件 进行分页查询
    *
    * @param query 查询对象
    * @return PageUtils 分页结果
    */
    public PageUtils queryPage(MemberTenantExtraPropertyQuery query);


    /**
     * 添加一条数据
     *
     * @param memberTenantExtraPropertyCommand 数据对象
     * @return 是否执行成功
     */
    boolean save(MemberTenantExtraPropertyCommand memberTenantExtraPropertyCommand);

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
     * @param memberTenantExtraPropertyCommand 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberTenantExtraPropertyCommand memberTenantExtraPropertyCommand);

     /**
      * 根据id查询对象
      *
      * @param id id
      * @return 查询后的对象
      */
    MemberTenantExtraPropertyDTO getById(Integer id);


}
