package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.common.database.PageTransformUtil;
import com.coderpwh.member.infrastructure.persistence.converter.MemberTenantExtraPropertyConverter;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import javax.annotation.Resource;
import com.coderpwh.member.domain.model.MemberTenantExtraPropertyRepository;
import com.github.pagehelper.PageHelper;
import java.io.Serializable;
import com.coderpwh.member.domain.model.MemberTenantExtraProperty;
import java.util.List;
import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantExtraPropertyDO;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberTenantExtraPropertyMapper;
import com.coderpwh.member.application.command.MemberTenantExtraPropertyQuery;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 租户额外属性表 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Service
public class MemberTenantExtraPropertyRepositoryImpl extends ServiceImpl<MemberTenantExtraPropertyMapper, MemberTenantExtraPropertyDO> implements MemberTenantExtraPropertyRepository {


    @Resource
    private MemberTenantExtraPropertyConverter memberTenantExtraPropertyConverter;


    @Override
    public PageUtils queryPage(MemberTenantExtraPropertyQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MemberTenantExtraPropertyDO> doList = this.list(Wrappers.<MemberTenantExtraPropertyDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<MemberTenantExtraProperty> pageList = memberTenantExtraPropertyConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }




    @Override
    public List<MemberTenantExtraProperty> queryList(MemberTenantExtraPropertyQuery query){
        List<MemberTenantExtraPropertyDO> doList = this.list(Wrappers.<MemberTenantExtraPropertyDO>lambdaQuery());
        List<MemberTenantExtraProperty> list = memberTenantExtraPropertyConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<MemberTenantExtraProperty> list){
        List<MemberTenantExtraPropertyDO> saveList = memberTenantExtraPropertyConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(MemberTenantExtraProperty memberTenantExtraProperty){
        MemberTenantExtraPropertyDO saveDO = memberTenantExtraPropertyConverter.toDTO(memberTenantExtraProperty);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id){
        return super.removeById(id);
    }

    @Override
    public boolean updateById(MemberTenantExtraProperty memberTenantExtraProperty){
        MemberTenantExtraPropertyDO updateDO = memberTenantExtraPropertyConverter.toDTO(memberTenantExtraProperty);
        return super.updateById(updateDO);
    }

    @Override
    public MemberTenantExtraProperty getById(Integer id){
        MemberTenantExtraPropertyDO entityDO = super.getById(id);
        return memberTenantExtraPropertyConverter.toEntity(entityDO);
    }

    @Override
    public List<MemberTenantExtraProperty> getByIds(List<Integer> ids){
        List<MemberTenantExtraPropertyDO> entityList = this.list(Wrappers.<MemberTenantExtraPropertyDO>lambdaQuery()
                .in(MemberTenantExtraPropertyDO::getId, ids));
        return memberTenantExtraPropertyConverter.toEntity(entityList);
    }

}
