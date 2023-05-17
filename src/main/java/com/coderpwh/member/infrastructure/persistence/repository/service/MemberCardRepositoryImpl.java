package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import javax.annotation.Resource;

import com.coderpwh.member.common.database.PageTransformUtil;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.UserLogin;
import com.github.pagehelper.PageHelper;
import com.coderpwh.member.application.command.MemberCardQuery;
import com.coderpwh.member.domain.model.MemberCardRepository;

import java.util.List;

import com.coderpwh.member.domain.model.MemberCard;
import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.converter.MemberCardConverter;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberCardMapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCardDO;

/**
 * <p>
 * 用户卡信息 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Service
public class MemberCardRepositoryImpl extends ServiceImpl<MemberCardMapper, MemberCardDO> implements MemberCardRepository {


    @Resource
    private MemberCardConverter memberCardConverter;


    @Override
    public PageUtils queryPage(MemberCardQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MemberCardDO> doList = this.list(Wrappers.<MemberCardDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<MemberCard> pageList = memberCardConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }


    @Override
    public List<MemberCard> queryList(MemberCardQuery query) {
        List<MemberCardDO> doList = this.list(Wrappers.<MemberCardDO>lambdaQuery());
        List<MemberCard> list = memberCardConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<MemberCard> list) {
        List<MemberCardDO> saveList = memberCardConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(MemberCard memberCard) {
        MemberCardDO saveDO = memberCardConverter.toDTO(memberCard);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id) {
        return super.removeById(id);
    }

    @Override
    public boolean updateById(MemberCard memberCard) {
        MemberCardDO updateDO = memberCardConverter.toDTO(memberCard);
        return super.updateById(updateDO);
    }

    @Override
    public MemberCard getById(Integer id) {
        MemberCardDO entityDO = super.getById(id);
        return memberCardConverter.toEntity(entityDO);
    }

    @Override
    public List<MemberCard> getByIds(List<Integer> ids) {
        List<MemberCardDO> entityList = this.list(Wrappers.<MemberCardDO>lambdaQuery()
                .in(MemberCardDO::getId, ids));
        return memberCardConverter.toEntity(entityList);
    }

    @Override
    public UserLogin selectByUserId(Long userId) {
        UserLogin userLogin = baseMapper.selectByUserId(userId);
        return userLogin;
    }

}
