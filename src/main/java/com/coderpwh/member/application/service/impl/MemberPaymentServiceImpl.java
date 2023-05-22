package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javax.annotation.Resource;

import com.coderpwh.member.application.dto.MemberPaymentDTO;
import com.coderpwh.member.application.service.MemberPaymentService;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPaymentDO;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberPaymentMapper;
import com.coderpwh.member.domain.model.MemberPaymentRepository;
import java.util.List;
import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import com.coderpwh.member.application.assembler.domain.MemberPaymentDTOAssembler;
import com.coderpwh.member.application.assembler.command.MemberPaymentAssembler;
import com.coderpwh.member.application.command.MemberPaymentCommand;
import com.coderpwh.member.domain.model.MemberPayment;
import com.coderpwh.member.application.command.MemberPaymentQuery;

/**
 * <p>
 * 租户支付方式 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-22
 */
@Service
public class MemberPaymentServiceImpl extends ServiceImpl<MemberPaymentMapper, MemberPaymentDO> implements MemberPaymentService {

    @Resource
    private MemberPaymentRepository memberPaymentRepository;
    @Resource
    private MemberPaymentAssembler memberPaymentAssembler;
    @Resource
    private MemberPaymentDTOAssembler memberPaymentDTOAssembler;



    @Override
    public PageUtils queryPage(MemberPaymentQuery query) {
        // 查询分页数据
        PageUtils pageUtils = memberPaymentRepository.queryPage(query);
        List<MemberPayment> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<MemberPaymentDTO> dtoList = memberPaymentDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(MemberPaymentCommand memberPaymentCommand){
        MemberPayment domain = memberPaymentAssembler.toEntity(memberPaymentCommand);
        return memberPaymentRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return memberPaymentRepository.deleteById(id);
    }

    @Override
    public boolean updateById(MemberPaymentCommand memberPaymentCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (memberPaymentCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberPayment domain = memberPaymentAssembler.toEntity(memberPaymentCommand);
        return memberPaymentRepository.updateById(domain);
    }

    @Override
    public MemberPaymentDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberPayment domain = memberPaymentRepository.getById(id);
        return memberPaymentDTOAssembler.toDTO(domain);
    }
}
