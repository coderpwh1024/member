package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import javax.annotation.Resource;

import com.coderpwh.member.common.database.PageTransformUtil;
import com.coderpwh.member.common.database.PageUtils;
import com.github.pagehelper.PageHelper;
import com.coderpwh.member.domain.model.MemberCallbackConfig;
import com.coderpwh.member.domain.model.MemberCallbackConfigRepository;
import java.util.List;
import com.coderpwh.member.application.command.MemberCallbackConfigQuery;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCallbackConfigDO;
import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberCallbackConfigMapper;
import com.coderpwh.member.infrastructure.persistence.converter.MemberCallbackConfigConverter;

/**
 * <p>
 * 回调配置 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Service
public class MemberCallbackConfigRepositoryImpl extends ServiceImpl<MemberCallbackConfigMapper, MemberCallbackConfigDO> implements MemberCallbackConfigRepository {


    @Resource
    private MemberCallbackConfigConverter memberCallbackConfigConverter;


    @Override
    public PageUtils queryPage(MemberCallbackConfigQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MemberCallbackConfigDO> doList = this.list(Wrappers.<MemberCallbackConfigDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<MemberCallbackConfig> pageList = memberCallbackConfigConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }




    @Override
    public List<MemberCallbackConfig> queryList(MemberCallbackConfigQuery query){
        List<MemberCallbackConfigDO> doList = this.list(Wrappers.<MemberCallbackConfigDO>lambdaQuery());
        List<MemberCallbackConfig> list = memberCallbackConfigConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<MemberCallbackConfig> list){
        List<MemberCallbackConfigDO> saveList = memberCallbackConfigConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(MemberCallbackConfig memberCallbackConfig){
        MemberCallbackConfigDO saveDO = memberCallbackConfigConverter.toDTO(memberCallbackConfig);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id){
        return super.removeById(id);
    }

    @Override
    public boolean updateById(MemberCallbackConfig memberCallbackConfig){
        MemberCallbackConfigDO updateDO = memberCallbackConfigConverter.toDTO(memberCallbackConfig);
        return super.updateById(updateDO);
    }

    @Override
    public MemberCallbackConfig getById(Integer id){
        MemberCallbackConfigDO entityDO = super.getById(id);
        return memberCallbackConfigConverter.toEntity(entityDO);
    }

    @Override
    public List<MemberCallbackConfig> getByIds(List<Integer> ids){
        List<MemberCallbackConfigDO> entityList = this.list(Wrappers.<MemberCallbackConfigDO>lambdaQuery()
                .in(MemberCallbackConfigDO::getId, ids));
        return memberCallbackConfigConverter.toEntity(entityList);
    }

}
