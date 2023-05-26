package com.coderpwh.member.infrastructure.persistence.repository.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import javax.annotation.Resource;

import com.coderpwh.member.common.database.PageTransformUtil;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPaymentDO;
import com.github.pagehelper.PageHelper;
import com.coderpwh.member.infrastructure.persistence.converter.MemberPaymentConverter;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberPaymentMapper;
import com.coderpwh.member.domain.model.MemberPaymentRepository;

import java.util.List;

import org.springframework.stereotype.Service;
import com.coderpwh.member.domain.model.MemberPayment;
import com.coderpwh.member.application.command.MemberPaymentQuery;

/**
 * <p>
 * 租户支付方式 仓储实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Service
public class MemberPaymentRepositoryImpl extends ServiceImpl<MemberPaymentMapper, MemberPaymentDO> implements MemberPaymentRepository {


    @Resource
    private MemberPaymentConverter memberPaymentConverter;


    @Override
    public PageUtils queryPage(MemberPaymentQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MemberPaymentDO> doList = this.list(Wrappers.<MemberPaymentDO>lambdaQuery());

        PageUtils page = PageTransformUtil.transform(doList);
        List<MemberPayment> pageList = memberPaymentConverter.toEntity(doList);
        page.setList(pageList);
        return page;
    }


    @Override
    public List<MemberPayment> queryList(MemberPaymentQuery query) {
        List<MemberPaymentDO> doList = this.list(Wrappers.<MemberPaymentDO>lambdaQuery());
        List<MemberPayment> list = memberPaymentConverter.toEntity(doList);
        return list;
    }

    @Override
    public boolean saveBatch(List<MemberPayment> list) {
        List<MemberPaymentDO> saveList = memberPaymentConverter.toDTO(list);
        return super.saveBatch(saveList);
    }

    @Override
    public boolean save(MemberPayment memberPayment) {
        MemberPaymentDO saveDO = memberPaymentConverter.toDTO(memberPayment);
        return super.save(saveDO);
    }

    @Override
    public boolean deleteById(Integer id) {
        return super.removeById(id);
    }

    @Override
    public boolean updateById(MemberPayment memberPayment) {
        MemberPaymentDO updateDO = memberPaymentConverter.toDTO(memberPayment);
        return super.updateById(updateDO);
    }

    @Override
    public MemberPayment getById(Integer id) {
        MemberPaymentDO entityDO = super.getById(id);
        return memberPaymentConverter.toEntity(entityDO);
    }

    @Override
    public List<MemberPayment> getByIds(List<Integer> ids) {
        List<MemberPaymentDO> entityList = this.list(Wrappers.<MemberPaymentDO>lambdaQuery()
                .in(MemberPaymentDO::getId, ids));
        return memberPaymentConverter.toEntity(entityList);
    }

    @Override
    public MemberPayment selectByPayType(Long tenantId, String payType, String env, String category) {
        MemberPaymentDO memberPaymentDO = baseMapper.selectByPayType(tenantId, payType, env, category);
        return memberPaymentConverter.toEntity(memberPaymentDO);
    }

}
