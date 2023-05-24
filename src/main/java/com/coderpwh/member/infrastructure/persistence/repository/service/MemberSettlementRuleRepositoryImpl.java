package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.common.database.PageTransformUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coderpwh.member.domain.model.MemberSettlementRule;
import com.coderpwh.member.infrastructure.persistence.entity.MemberSettlementRuleDO;
import javax.annotation.Resource;
import com.github.pagehelper.PageHelper;
import com.coderpwh.member.domain.model.MemberSettlementRuleRepository;
import java.io.Serializable;
import com.coderpwh.member.infrastructure.persistence.converter.MemberSettlementRuleConverter;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberSettlementRuleMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import com.coderpwh.member.application.command.MemberSettlementRuleQuery;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 结算规则 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-24
 */
@Service
public class MemberSettlementRuleRepositoryImpl extends ServiceImpl<MemberSettlementRuleMapper, MemberSettlementRuleDO> implements MemberSettlementRuleRepository {


    @Resource
    private MemberSettlementRuleConverter memberSettlementRuleConverter;


    @Override
    public PageUtils queryPage(MemberSettlementRuleQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MemberSettlementRuleDO> doList = this.list(Wrappers.<MemberSettlementRuleDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<MemberSettlementRule> pageList = memberSettlementRuleConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }




    @Override
    public List<MemberSettlementRule> queryList(MemberSettlementRuleQuery query){
        List<MemberSettlementRuleDO> doList = this.list(Wrappers.<MemberSettlementRuleDO>lambdaQuery());
        List<MemberSettlementRule> list = memberSettlementRuleConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<MemberSettlementRule> list){
        List<MemberSettlementRuleDO> saveList = memberSettlementRuleConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(MemberSettlementRule memberSettlementRule){
        MemberSettlementRuleDO saveDO = memberSettlementRuleConverter.toDTO(memberSettlementRule);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id){
        return super.removeById(id);
    }

    @Override
    public boolean updateById(MemberSettlementRule memberSettlementRule){
        MemberSettlementRuleDO updateDO = memberSettlementRuleConverter.toDTO(memberSettlementRule);
        return super.updateById(updateDO);
    }

    @Override
    public MemberSettlementRule getById(Integer id){
        MemberSettlementRuleDO entityDO = super.getById(id);
        return memberSettlementRuleConverter.toEntity(entityDO);
    }

    @Override
    public List<MemberSettlementRule> getByIds(List<Integer> ids){
        List<MemberSettlementRuleDO> entityList = this.list(Wrappers.<MemberSettlementRuleDO>lambdaQuery()
                .in(MemberSettlementRuleDO::getId, ids));
        return memberSettlementRuleConverter.toEntity(entityList);
    }

}
