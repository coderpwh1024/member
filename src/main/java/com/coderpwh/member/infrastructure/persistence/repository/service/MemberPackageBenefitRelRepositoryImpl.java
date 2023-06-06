package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coderpwh.member.application.dto.BenefitDTO;
import com.coderpwh.member.common.database.PageTransformUtil;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.MemberPackageBenefitRel;

import javax.annotation.Resource;

import com.coderpwh.member.infrastructure.persistence.mapper.MemberPackageBenefitRelMapper;
import com.github.pagehelper.PageHelper;
import com.coderpwh.member.application.command.MemberPackageBenefitRelQuery;
import com.coderpwh.member.domain.model.MemberPackageBenefitRelRepository;

import java.util.List;

import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.converter.MemberPackageBenefitRelConverter;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPackageBenefitRelDO;

/**
 * <p>
 * 会员套餐权益配比 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Service
public class MemberPackageBenefitRelRepositoryImpl extends ServiceImpl<MemberPackageBenefitRelMapper, MemberPackageBenefitRelDO> implements MemberPackageBenefitRelRepository {


    @Resource
    private MemberPackageBenefitRelConverter memberPackageBenefitRelConverter;


    @Override
    public PageUtils queryPage(MemberPackageBenefitRelQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MemberPackageBenefitRelDO> doList = this.list(Wrappers.<MemberPackageBenefitRelDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<MemberPackageBenefitRel> pageList = memberPackageBenefitRelConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }


    @Override
    public List<MemberPackageBenefitRel> queryList(MemberPackageBenefitRelQuery query) {
        List<MemberPackageBenefitRelDO> doList = this.list(Wrappers.<MemberPackageBenefitRelDO>lambdaQuery());
        List<MemberPackageBenefitRel> list = memberPackageBenefitRelConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<MemberPackageBenefitRel> list) {
        List<MemberPackageBenefitRelDO> saveList = memberPackageBenefitRelConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(MemberPackageBenefitRel memberPackageBenefitRel) {
        MemberPackageBenefitRelDO saveDO = memberPackageBenefitRelConverter.toDTO(memberPackageBenefitRel);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id) {
        return super.removeById(id);
    }

    @Override
    public boolean updateById(MemberPackageBenefitRel memberPackageBenefitRel) {
        MemberPackageBenefitRelDO updateDO = memberPackageBenefitRelConverter.toDTO(memberPackageBenefitRel);
        return super.updateById(updateDO);
    }

    @Override
    public MemberPackageBenefitRel getById(Integer id) {
        MemberPackageBenefitRelDO entityDO = super.getById(id);
        return memberPackageBenefitRelConverter.toEntity(entityDO);
    }

    @Override
    public List<MemberPackageBenefitRel> getByIds(List<Integer> ids) {
        List<MemberPackageBenefitRelDO> entityList = this.list(Wrappers.<MemberPackageBenefitRelDO>lambdaQuery().in(MemberPackageBenefitRelDO::getId, ids));
        return memberPackageBenefitRelConverter.toEntity(entityList);
    }


    /***
     *  根据租户id和pckageId查询
     * @param tenantId
     * @param packageId
     * @return
     */
    @Override
    public List<MemberPackageBenefitRel> selectByTenantIdAndPackageId(Long tenantId, Long packageId) {

        List<MemberPackageBenefitRelDO> list = baseMapper.selectByTenantIdAndPackageId(tenantId, packageId);

        if (list != null && list.size() > 0) {
            return memberPackageBenefitRelConverter.toEntity(list);
        } else {
            return null;
        }
    }


    @Override
    public List<BenefitDTO> getByTenantIdAndPackageId(Long tenantId, Long packageId) {
        List<BenefitDTO> list = baseMapper.getByTenantIdAndPackageId(tenantId, packageId);
        return list;
    }


}
