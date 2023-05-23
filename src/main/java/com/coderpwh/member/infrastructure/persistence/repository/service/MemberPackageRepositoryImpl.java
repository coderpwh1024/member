package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coderpwh.member.common.database.PageTransformUtil;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.MemberPackageRepository;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.coderpwh.member.infrastructure.persistence.converter.MemberPackageConverter;

import java.util.List;

import com.coderpwh.member.domain.model.MemberPackage;
import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPackageDO;
import com.coderpwh.member.application.command.MemberPackageQuery;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberPackageMapper;

/**
 * <p>
 * 会员套餐包 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Service
public class MemberPackageRepositoryImpl extends ServiceImpl<MemberPackageMapper, MemberPackageDO> implements MemberPackageRepository {


    @Resource
    private MemberPackageConverter memberPackageConverter;


    @Override
    public PageUtils queryPage(MemberPackageQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MemberPackageDO> doList = this.list(Wrappers.<MemberPackageDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<MemberPackage> pageList = memberPackageConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }


    @Override
    public List<MemberPackage> queryList(MemberPackageQuery query) {
        List<MemberPackageDO> doList = this.list(Wrappers.<MemberPackageDO>lambdaQuery());
        List<MemberPackage> list = memberPackageConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<MemberPackage> list) {
        List<MemberPackageDO> saveList = memberPackageConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(MemberPackage memberPackage) {
        MemberPackageDO saveDO = memberPackageConverter.toDTO(memberPackage);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id) {
        return super.removeById(id);
    }

    @Override
    public boolean updateById(MemberPackage memberPackage) {
        MemberPackageDO updateDO = memberPackageConverter.toDTO(memberPackage);
        return super.updateById(updateDO);
    }

    @Override
    public MemberPackage getById(Integer id) {
        MemberPackageDO entityDO = super.getById(id);
        return memberPackageConverter.toEntity(entityDO);
    }

    @Override
    public List<MemberPackage> getByIds(List<Integer> ids) {
        List<MemberPackageDO> entityList = this.list(Wrappers.<MemberPackageDO>lambdaQuery().in(MemberPackageDO::getId, ids));
        return memberPackageConverter.toEntity(entityList);
    }


    /***
     * 通过编码查询
     * @param tenantId
     * @param packageCode
     * @return
     */
    @Override
    public MemberPackage selectByPackageCode(String tenantId, String packageCode) {
        MemberPackageDO memberPackageDO = baseMapper.selectByPackageCode(tenantId, packageCode);
        return memberPackageConverter.toEntity(memberPackageDO);
    }


    /***
     *  通过agentNumber跟productType查询
     * @param agentNumber
     * @param productType
     * @return
     */
    @Override
    public MemberPackage selectByAgentNumberAndCode(String agentNumber, String productType) {
        MemberPackageDO memberPackageDO = baseMapper.selectByAgentNumberAndCode(agentNumber, productType);

        return null;
    }


}
