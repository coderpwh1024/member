package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.MemberTenantExtraInfoCommand;
import com.coderpwh.member.application.command.MemberTenantExtraInfoQuery;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.application.dto.MemberTenantExtraInfoDTO;

/**
 * <p>
 * 租户额外信息表 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
public interface MemberTenantExtraInfoService {

    /**
    * 根据传入的command作为检索条件 进行分页查询
    *
    * @param query 查询对象
    * @return PageUtils 分页结果
    */
    public PageUtils queryPage(MemberTenantExtraInfoQuery query);


    /**
     * 添加一条数据
     *
     * @param memberTenantExtraInfoCommand 数据对象
     * @return 是否执行成功
     */
    boolean save(MemberTenantExtraInfoCommand memberTenantExtraInfoCommand);

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
     * @param memberTenantExtraInfoCommand 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberTenantExtraInfoCommand memberTenantExtraInfoCommand);

     /**
      * 根据id查询对象
      *
      * @param id id
      * @return 查询后的对象
      */
    MemberTenantExtraInfoDTO getById(Integer id);


}
