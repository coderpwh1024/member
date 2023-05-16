package com.coderpwh.member.application.service;


import com.coderpwh.member.application.command.MemberCardHistoryCommand;
import com.coderpwh.member.application.command.MemberCardHistoryQuery;
import com.coderpwh.member.application.dto.MemberCardHistoryDTO;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 用户卡历史 服务类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
public interface MemberCardHistoryService {

    /**
    * 根据传入的command作为检索条件 进行分页查询
    *
    * @param query 查询对象
    * @return PageUtils 分页结果
    */
    public PageUtils queryPage(MemberCardHistoryQuery query);


    /**
     * 添加一条数据
     *
     * @param memberCardHistoryCommand 数据对象
     * @return 是否执行成功
     */
    boolean save(MemberCardHistoryCommand memberCardHistoryCommand);

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
     * @param memberCardHistoryCommand 实体对象
     * @return 是否执行成功
     */
    boolean updateById(MemberCardHistoryCommand memberCardHistoryCommand);

     /**
      * 根据id查询对象
      *
      * @param id id
      * @return 查询后的对象
      */
    MemberCardHistoryDTO getById(Integer id);


}
