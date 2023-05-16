package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.common.database.PageTransformUtil;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.infrastructure.persistence.converter.MemberUserConverter;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coderpwh.member.domain.model.MemberUser;
import com.coderpwh.member.domain.model.MemberUserRepository;
import com.coderpwh.member.infrastructure.persistence.entity.MemberUserDO;
import javax.annotation.Resource;
import com.github.pagehelper.PageHelper;
import com.coderpwh.member.application.command.MemberUserQuery;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberUserMapper;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Service
public class MemberUserRepositoryImpl extends ServiceImpl<MemberUserMapper, MemberUserDO> implements MemberUserRepository {


    @Resource
    private MemberUserConverter memberUserConverter;


    @Override
    public PageUtils queryPage(MemberUserQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MemberUserDO> doList = this.list(Wrappers.<MemberUserDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<MemberUser> pageList = memberUserConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }




    @Override
    public List<MemberUser> queryList(MemberUserQuery query){
        List<MemberUserDO> doList = this.list(Wrappers.<MemberUserDO>lambdaQuery());
        List<MemberUser> list = memberUserConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<MemberUser> list){
        List<MemberUserDO> saveList = memberUserConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(MemberUser memberUser){
        MemberUserDO saveDO = memberUserConverter.toDTO(memberUser);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id){
        return super.removeById(id);
    }

    @Override
    public boolean updateById(MemberUser memberUser){
        MemberUserDO updateDO = memberUserConverter.toDTO(memberUser);
        return super.updateById(updateDO);
    }

    @Override
    public MemberUser getById(Integer id){
        MemberUserDO entityDO = super.getById(id);
        return memberUserConverter.toEntity(entityDO);
    }

    @Override
    public List<MemberUser> getByIds(List<Integer> ids){
        List<MemberUserDO> entityList = this.list(Wrappers.<MemberUserDO>lambdaQuery()
                .in(MemberUserDO::getId, ids));
        return memberUserConverter.toEntity(entityList);
    }

}
