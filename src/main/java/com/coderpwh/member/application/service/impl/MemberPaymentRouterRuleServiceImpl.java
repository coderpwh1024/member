package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.assembler.domain.MemberPaymentRouterRuleDTOAssembler;
import com.coderpwh.member.application.service.MemberPaymentRouterRuleService;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.MemberPaymentRouterRule;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPaymentRouterRuleDO;
import javax.annotation.Resource;
import java.util.List;
import cn.hutool.core.collection.CollUtil;
import com.coderpwh.member.application.command.MemberPaymentRouterRuleCommand;
import com.coderpwh.member.application.command.MemberPaymentRouterRuleQuery;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberPaymentRouterRuleMapper;
import org.springframework.stereotype.Service;
import com.coderpwh.member.domain.model.MemberPaymentRouterRuleRepository;
import com.coderpwh.member.application.dto.MemberPaymentRouterRuleDTO;
import com.coderpwh.member.application.assembler.command.MemberPaymentRouterRuleAssembler;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Service
public class MemberPaymentRouterRuleServiceImpl extends ServiceImpl<MemberPaymentRouterRuleMapper, MemberPaymentRouterRuleDO> implements MemberPaymentRouterRuleService {

    @Resource
    private MemberPaymentRouterRuleRepository memberPaymentRouterRuleRepository;
    @Resource
    private MemberPaymentRouterRuleAssembler memberPaymentRouterRuleAssembler;
    @Resource
    private MemberPaymentRouterRuleDTOAssembler memberPaymentRouterRuleDTOAssembler;



    @Override
    public PageUtils queryPage(MemberPaymentRouterRuleQuery query) {
        // 查询分页数据
        PageUtils pageUtils = memberPaymentRouterRuleRepository.queryPage(query);
        List<MemberPaymentRouterRule> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<MemberPaymentRouterRuleDTO> dtoList = memberPaymentRouterRuleDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(MemberPaymentRouterRuleCommand memberPaymentRouterRuleCommand){
        MemberPaymentRouterRule domain = memberPaymentRouterRuleAssembler.toEntity(memberPaymentRouterRuleCommand);
        return memberPaymentRouterRuleRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return memberPaymentRouterRuleRepository.deleteById(id);
    }

    @Override
    public boolean updateById(MemberPaymentRouterRuleCommand memberPaymentRouterRuleCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (memberPaymentRouterRuleCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberPaymentRouterRule domain = memberPaymentRouterRuleAssembler.toEntity(memberPaymentRouterRuleCommand);
        return memberPaymentRouterRuleRepository.updateById(domain);
    }

    @Override
    public MemberPaymentRouterRuleDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberPaymentRouterRule domain = memberPaymentRouterRuleRepository.getById(id);
        return memberPaymentRouterRuleDTOAssembler.toDTO(domain);
    }
}
