package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.dto.TenantPropertyDTO;
import com.coderpwh.member.common.database.PageTransformUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coderpwh.member.application.command.MemberTenantExtraInfoQuery;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantExtraInfoDO;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;

import java.io.Serializable;

import com.coderpwh.member.infrastructure.persistence.mapper.MemberTenantExtraInfoMapper;

import java.util.List;

import com.coderpwh.member.infrastructure.persistence.converter.MemberTenantExtraInfoConverter;
import com.coderpwh.member.domain.model.MemberTenantExtraInfo;
import org.springframework.stereotype.Service;
import com.coderpwh.member.domain.model.MemberTenantExtraInfoRepository;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 租户额外信息表 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Service
public class MemberTenantExtraInfoRepositoryImpl extends ServiceImpl<MemberTenantExtraInfoMapper, MemberTenantExtraInfoDO> implements MemberTenantExtraInfoRepository {


    @Resource
    private MemberTenantExtraInfoConverter memberTenantExtraInfoConverter;


    @Override
    public PageUtils queryPage(MemberTenantExtraInfoQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MemberTenantExtraInfoDO> doList = this.list(Wrappers.<MemberTenantExtraInfoDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<MemberTenantExtraInfo> pageList = memberTenantExtraInfoConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }


    @Override
    public List<MemberTenantExtraInfo> queryList(MemberTenantExtraInfoQuery query) {
        List<MemberTenantExtraInfoDO> doList = this.list(Wrappers.<MemberTenantExtraInfoDO>lambdaQuery());
        List<MemberTenantExtraInfo> list = memberTenantExtraInfoConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<MemberTenantExtraInfo> list) {
        List<MemberTenantExtraInfoDO> saveList = memberTenantExtraInfoConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(MemberTenantExtraInfo memberTenantExtraInfo) {
        MemberTenantExtraInfoDO saveDO = memberTenantExtraInfoConverter.toDTO(memberTenantExtraInfo);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id) {
        return super.removeById(id);
    }

    @Override
    public boolean updateById(MemberTenantExtraInfo memberTenantExtraInfo) {
        MemberTenantExtraInfoDO updateDO = memberTenantExtraInfoConverter.toDTO(memberTenantExtraInfo);
        return super.updateById(updateDO);
    }

    @Override
    public MemberTenantExtraInfo getById(Integer id) {
        MemberTenantExtraInfoDO entityDO = super.getById(id);
        return memberTenantExtraInfoConverter.toEntity(entityDO);
    }

    @Override
    public List<MemberTenantExtraInfo> getByIds(List<Integer> ids) {
        List<MemberTenantExtraInfoDO> entityList = this.list(Wrappers.<MemberTenantExtraInfoDO>lambdaQuery().in(MemberTenantExtraInfoDO::getId, ids));
        return memberTenantExtraInfoConverter.toEntity(entityList);
    }


    /***
     * 通过租户id查询
     * @param id
     * @param overdueRefundKey
     * @return
     */
    @Override
    public List<TenantPropertyDTO> selectByTenantId(Long tenantId, String overdueRefundKey) {
        List<TenantPropertyDTO> entityList = baseMapper.selectByTenantId(tenantId, overdueRefundKey);

        return null;
    }


}
