package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.MemberJoinCommand;
import com.coderpwh.member.application.command.MemberPackageDetailQuery;
import com.coderpwh.member.application.command.MemberRefundCommand;
import com.coderpwh.member.application.vo.MemberRefundVO;
import com.coderpwh.member.application.vo.MemberSaveVO;

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
     * 会员注销
     * @param command
     * @return
     */
    MemberRefundVO refundMember(MemberRefundCommand command);


    /***
     * 查询会员权益包
     * @param query
     * @return
     */

    String getPackageDetail(MemberPackageDetailQuery query);

}
