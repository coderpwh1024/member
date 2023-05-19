package com.coderpwh.member.application.service;

import com.coderpwh.member.application.dto.MemberPackageDTO;
import com.coderpwh.member.application.command.MemberPackageQuery;
import com.coderpwh.member.application.command.MemberPackageCommand;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 会员套餐包 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
public interface MemberPackageService {

    /**
    * 根据传入的command作为检索条件 进行分页查询
    *
    * @param query 查询对象
    * @return PageUtils 分页结果
    */
    public PageUtils queryPage(MemberPackageQuery query);


    /**
     * 添加一条数据
     *
     * @param memberPackageCommand 数据对象
     * @return 是否执行成功
     */
    boolean save(MemberPackageCommand memberPackageCommand);

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
     * @param memberPackageCommand 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberPackageCommand memberPackageCommand);

     /**
      * 根据id查询对象
      *
      * @param id id
      * @return 查询后的对象
      */
    MemberPackageDTO getById(Integer id);


}
