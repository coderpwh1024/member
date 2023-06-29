package com.coderpwh.member.infrastructure.persistence.repository.service;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.common.database.PageTransformUtil;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.MemberCardHistoryRepository;
import com.coderpwh.member.infrastructure.persistence.converter.MemberCardHistoryConverter;

import javax.annotation.Resource;

import com.coderpwh.member.infrastructure.persistence.entity.MemberCardHistoryDO;
import com.github.pagehelper.PageHelper;
import com.coderpwh.member.domain.model.MemberCardHistory;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberCardHistoryMapper;

import java.util.List;

import com.coderpwh.member.application.command.MemberCardHistoryQuery;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户卡历史 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Service
public class MemberCardHistoryRepositoryImpl extends ServiceImpl<MemberCardHistoryMapper, MemberCardHistoryDO> implements MemberCardHistoryRepository {


    @Resource
    private MemberCardHistoryConverter memberCardHistoryConverter;


    @Override
    public PageUtils queryPage(MemberCardHistoryQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MemberCardHistoryDO> doList = this.list(Wrappers.<MemberCardHistoryDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<MemberCardHistory> pageList = memberCardHistoryConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }


    @Override
    public List<MemberCardHistory> queryList(MemberCardHistoryQuery query) {
        List<MemberCardHistoryDO> doList = this.list(Wrappers.<MemberCardHistoryDO>lambdaQuery());
        List<MemberCardHistory> list = memberCardHistoryConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<MemberCardHistory> list) {
        List<MemberCardHistoryDO> saveList = memberCardHistoryConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(MemberCardHistory memberCardHistory) {
        MemberCardHistoryDO saveDO = memberCardHistoryConverter.toDTO(memberCardHistory);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id) {
        return super.removeById(id);
    }

    @Override
    public boolean updateById(MemberCardHistory memberCardHistory) {
        MemberCardHistoryDO updateDO = memberCardHistoryConverter.toDTO(memberCardHistory);
        return super.updateById(updateDO);
    }

    @Override
    public MemberCardHistory getById(Integer id) {
        MemberCardHistoryDO entityDO = super.getById(id);
        return memberCardHistoryConverter.toEntity(entityDO);
    }

    @Override
    public List<MemberCardHistory> getByIds(List<Integer> ids) {
        List<MemberCardHistoryDO> entityList = this.list(Wrappers.<MemberCardHistoryDO>lambdaQuery().in(MemberCardHistoryDO::getId, ids));
        return memberCardHistoryConverter.toEntity(entityList);
    }


    /**
     * 通过userId查询
     *
     * @param userId
     * @param orderNumber
     * @return
     */
    @Override
    public List<MemberCardHistory> getLastOrder(Long userId, String orderNumber) {
        List<MemberCardHistoryDO> entityList = baseMapper.getValidOrderByUserId(userId);
        List<MemberCardHistory> list = memberCardHistoryConverter.toEntity(entityList);
        if (CollectionUtils.isNotEmpty(list)) {
            MemberCardHistory memberCardHistory = list.get(list.size() - 1);
            if (memberCardHistory.getOrderNumber().equals(orderNumber)) {
                return list;
            }
        }
        return null;
    }


    /***
     * 通过订单号查询卡历史
     * @param orderNumber
     * @return
     */
    @Override
    public MemberCardHistory selectByOrderNumber(String orderNumber) {
        MemberCardHistoryDO memberCardHistoryDO = baseMapper.selectByOrderNumber(orderNumber);
        return memberCardHistoryConverter.toEntity(memberCardHistoryDO);
    }


    /***
     * 通过订单号或合作方订单号查询
     * @param orderNumber
     * @param partnerOrderNumber
     * @return
     */
    @Override
    public MemberCardHistory selectByOrderNumberOrPatnerOrderNumber(String orderNumber, String partnerOrderNumber) {
        MemberCardHistoryDO memberCardHistoryDO = baseMapper.selectByOrderNumberOrPatnerOrderNumber(orderNumber, partnerOrderNumber);
        return memberCardHistoryConverter.toEntity(memberCardHistoryDO);
    }


    /***
     *
     * @param userId
     * @return
     */
    @Override
    public List<MemberCardHistory> selectByUserId(Long userId) {
        List<MemberCardHistoryDO> entityList = baseMapper.selectByUserId(userId);
        return memberCardHistoryConverter.toEntity(entityList);
    }


}
