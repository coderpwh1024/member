package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.service.MemberSettlementRuleService;
import com.coderpwh.member.domain.model.MemberSettlementRule;
import com.coderpwh.member.infrastructure.persistence.entity.MemberSettlementRuleDO;
import javax.annotation.Resource;
import com.coderpwh.member.application.dto.MemberSettlementRuleDTO;
import com.coderpwh.member.domain.model.MemberSettlementRuleRepository;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberSettlementRuleMapper;
import java.util.List;
import cn.hutool.core.collection.CollUtil;
import com.coderpwh.member.application.command.MemberSettlementRuleCommand;
import com.coderpwh.member.application.assembler.domain.MemberSettlementRuleDTOAssembler;
import org.springframework.stereotype.Service;
import com.coderpwh.member.application.assembler.command.MemberSettlementRuleAssembler;
import com.coderpwh.member.application.command.MemberSettlementRuleQuery;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 结算规则 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-24
 */
@Service
public class MemberSettlementRuleServiceImpl extends ServiceImpl<MemberSettlementRuleMapper, MemberSettlementRuleDO> implements MemberSettlementRuleService {

    @Resource
    private MemberSettlementRuleRepository memberSettlementRuleRepository;
    @Resource
    private MemberSettlementRuleAssembler memberSettlementRuleAssembler;
    @Resource
    private MemberSettlementRuleDTOAssembler memberSettlementRuleDTOAssembler;



    @Override
    public PageUtils queryPage(MemberSettlementRuleQuery query) {
        // 查询分页数据
        PageUtils pageUtils = memberSettlementRuleRepository.queryPage(query);
        List<MemberSettlementRule> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<MemberSettlementRuleDTO> dtoList = memberSettlementRuleDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(MemberSettlementRuleCommand memberSettlementRuleCommand){
        MemberSettlementRule domain = memberSettlementRuleAssembler.toEntity(memberSettlementRuleCommand);
        return memberSettlementRuleRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return memberSettlementRuleRepository.deleteById(id);
    }

    @Override
    public boolean updateById(MemberSettlementRuleCommand memberSettlementRuleCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (memberSettlementRuleCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberSettlementRule domain = memberSettlementRuleAssembler.toEntity(memberSettlementRuleCommand);
        return memberSettlementRuleRepository.updateById(domain);
    }

    @Override
    public MemberSettlementRuleDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberSettlementRule domain = memberSettlementRuleRepository.getById(id);
        return memberSettlementRuleDTOAssembler.toDTO(domain);
    }
}
