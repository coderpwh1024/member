package com.coderpwh.member.application.service;


import com.coderpwh.member.application.dto.MemberTenantDTO;
import com.coderpwh.member.application.command.MemberTenantQuery;
import com.coderpwh.member.application.command.MemberTenantCommand;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 租户空间 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
public interface MemberTenantService {

    /**
    * 根据传入的command作为检索条件 进行分页查询
    *
    * @param query 查询对象
    * @return PageUtils 分页结果
    */
    public PageUtils queryPage(MemberTenantQuery query);


    /**
     * 添加一条数据
     *
     * @param memberTenantCommand 数据对象
     * @return 是否执行成功
     */
    boolean save(MemberTenantCommand memberTenantCommand);

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
     * @param memberTenantCommand 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberTenantCommand memberTenantCommand);

     /**
      * 根据id查询对象
      *
      * @param id id
      * @return 查询后的对象
      */
    MemberTenantDTO getById(Integer id);


}
