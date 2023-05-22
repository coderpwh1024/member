package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coderpwh.member.common.database.PageTransformUtil;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.MemberPaymentRouterRule;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPaymentRouterRuleDO;
import com.coderpwh.member.infrastructure.persistence.converter.MemberPaymentRouterRuleConverter;
import javax.annotation.Resource;
import com.github.pagehelper.PageHelper;
import java.util.List;
import com.coderpwh.member.application.command.MemberPaymentRouterRuleQuery;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberPaymentRouterRuleMapper;
import org.springframework.stereotype.Service;
import com.coderpwh.member.domain.model.MemberPaymentRouterRuleRepository;

/**
 * <p>
 *  仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Service
public class MemberPaymentRouterRuleRepositoryImpl extends ServiceImpl<MemberPaymentRouterRuleMapper, MemberPaymentRouterRuleDO> implements MemberPaymentRouterRuleRepository {


    @Resource
    private MemberPaymentRouterRuleConverter memberPaymentRouterRuleConverter;


    @Override
    public PageUtils queryPage(MemberPaymentRouterRuleQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MemberPaymentRouterRuleDO> doList = this.list(Wrappers.<MemberPaymentRouterRuleDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<MemberPaymentRouterRule> pageList = memberPaymentRouterRuleConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }




    @Override
    public List<MemberPaymentRouterRule> queryList(MemberPaymentRouterRuleQuery query){
        List<MemberPaymentRouterRuleDO> doList = this.list(Wrappers.<MemberPaymentRouterRuleDO>lambdaQuery());
        List<MemberPaymentRouterRule> list = memberPaymentRouterRuleConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<MemberPaymentRouterRule> list){
        List<MemberPaymentRouterRuleDO> saveList = memberPaymentRouterRuleConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(MemberPaymentRouterRule memberPaymentRouterRule){
        MemberPaymentRouterRuleDO saveDO = memberPaymentRouterRuleConverter.toDTO(memberPaymentRouterRule);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id){
        return super.removeById(id);
    }

    @Override
    public boolean updateById(MemberPaymentRouterRule memberPaymentRouterRule){
        MemberPaymentRouterRuleDO updateDO = memberPaymentRouterRuleConverter.toDTO(memberPaymentRouterRule);
        return super.updateById(updateDO);
    }

    @Override
    public MemberPaymentRouterRule getById(Integer id){
        MemberPaymentRouterRuleDO entityDO = super.getById(id);
        return memberPaymentRouterRuleConverter.toEntity(entityDO);
    }

    @Override
    public List<MemberPaymentRouterRule> getByIds(List<Integer> ids){
        List<MemberPaymentRouterRuleDO> entityList = this.list(Wrappers.<MemberPaymentRouterRuleDO>lambdaQuery()
                .in(MemberPaymentRouterRuleDO::getId, ids));
        return memberPaymentRouterRuleConverter.toEntity(entityList);
    }

}
