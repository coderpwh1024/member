package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.MemberJoinCommand;
import com.coderpwh.member.application.command.MemberPackageDetailQuery;
import com.coderpwh.member.application.command.MemberPackageOrderQuery;
import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.vo.MemberPackageDetailVO;
import com.coderpwh.member.application.vo.MemberPackageOrderVO;
import com.coderpwh.member.application.vo.MemberRefundVO;
import com.coderpwh.member.application.vo.MemberSaveVO;

import java.util.List;

/**
 * @author coderpwh
 * @date 2023/5/22 11:32
 */
public interface MemberService {


    /***
     * 开通会员
     * @param command
     * @return
     */
    MemberSaveVO saveMember(MemberJoinCommand command);


    /***
     * 查询会员权益包
     * @param query
     * @return
     */
    List<MemberPackageDetailVO> getPackageDetail(MemberPackageDetailQuery query);


    /***
     * 查询会员权益包订单
     * @param query
     * @return
     */
    MemberPackageOrderVO getParckageOrder(MemberPackageOrderQuery query);
}
