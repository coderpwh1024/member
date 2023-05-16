package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.common.database.PageTransformUtil;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberTenantMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coderpwh.member.domain.model.MemberTenantRepository;
import com.coderpwh.member.domain.model.MemberTenant;

import javax.annotation.Resource;

import com.coderpwh.member.infrastructure.persistence.converter.MemberTenantConverter;
import com.github.pagehelper.PageHelper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantDO;

import java.util.List;

import org.springframework.stereotype.Service;
import com.coderpwh.member.application.command.MemberTenantQuery;

/**
 * <p>
 * 租户空间 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Service
public class MemberTenantRepositoryImpl extends ServiceImpl<MemberTenantMapper, MemberTenantDO> implements MemberTenantRepository {


    @Resource
    private MemberTenantConverter memberTenantConverter;


    @Resource
    private MemberTenantMapper memberTenantMapper;


    @Override
    public PageUtils queryPage(MemberTenantQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MemberTenantDO> doList = this.list(Wrappers.<MemberTenantDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<MemberTenant> pageList = memberTenantConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }


    @Override
    public List<MemberTenant> queryList(MemberTenantQuery query) {
        List<MemberTenantDO> doList = this.list(Wrappers.<MemberTenantDO>lambdaQuery());
        List<MemberTenant> list = memberTenantConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<MemberTenant> list) {
        List<MemberTenantDO> saveList = memberTenantConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(MemberTenant memberTenant) {
        MemberTenantDO saveDO = memberTenantConverter.toDTO(memberTenant);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id) {
        return super.removeById(id);
    }

    @Override
    public boolean updateById(MemberTenant memberTenant) {
        MemberTenantDO updateDO = memberTenantConverter.toDTO(memberTenant);
        return super.updateById(updateDO);
    }

    @Override
    public MemberTenant getById(Integer id) {
        MemberTenantDO entityDO = super.getById(id);
        return memberTenantConverter.toEntity(entityDO);
    }

    @Override
    public List<MemberTenant> getByIds(List<Integer> ids) {
        List<MemberTenantDO> entityList = this.list(Wrappers.<MemberTenantDO>lambdaQuery()
                .in(MemberTenantDO::getId, ids));
        return memberTenantConverter.toEntity(entityList);
    }

    @Override
    public MemberTenant selectByAgentNumber(String agentNumber) {

        MemberTenantDO memberTenantDO = memberTenantMapper.selectByAgentNumber(agentNumber);
        return null;
    }

}
