package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.service.MemberPackageBenefitRelService;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.MemberPackageBenefitRel;
import com.coderpwh.member.application.assembler.domain.MemberPackageBenefitRelDTOAssembler;
import javax.annotation.Resource;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberPackageBenefitRelMapper;
import com.coderpwh.member.application.command.MemberPackageBenefitRelCommand;
import com.coderpwh.member.application.command.MemberPackageBenefitRelQuery;
import com.coderpwh.member.domain.model.MemberPackageBenefitRelRepository;
import java.util.List;
import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPackageBenefitRelDO;
import com.coderpwh.member.application.assembler.command.MemberPackageBenefitRelAssembler;
import com.coderpwh.member.application.dto.MemberPackageBenefitRelDTO;

/**
 * <p>
 * 会员套餐权益配比 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Service
public class MemberPackageBenefitRelServiceImpl extends ServiceImpl<MemberPackageBenefitRelMapper, MemberPackageBenefitRelDO> implements MemberPackageBenefitRelService {

    @Resource
    private MemberPackageBenefitRelRepository memberPackageBenefitRelRepository;
    @Resource
    private MemberPackageBenefitRelAssembler memberPackageBenefitRelAssembler;
    @Resource
    private MemberPackageBenefitRelDTOAssembler memberPackageBenefitRelDTOAssembler;



    @Override
    public PageUtils queryPage(MemberPackageBenefitRelQuery query) {
        // 查询分页数据
        PageUtils pageUtils = memberPackageBenefitRelRepository.queryPage(query);
        List<MemberPackageBenefitRel> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<MemberPackageBenefitRelDTO> dtoList = memberPackageBenefitRelDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(MemberPackageBenefitRelCommand memberPackageBenefitRelCommand){
        MemberPackageBenefitRel domain = memberPackageBenefitRelAssembler.toEntity(memberPackageBenefitRelCommand);
        return memberPackageBenefitRelRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return memberPackageBenefitRelRepository.deleteById(id);
    }

    @Override
    public boolean updateById(MemberPackageBenefitRelCommand memberPackageBenefitRelCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (memberPackageBenefitRelCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberPackageBenefitRel domain = memberPackageBenefitRelAssembler.toEntity(memberPackageBenefitRelCommand);
        return memberPackageBenefitRelRepository.updateById(domain);
    }

    @Override
    public MemberPackageBenefitRelDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberPackageBenefitRel domain = memberPackageBenefitRelRepository.getById(id);
        return memberPackageBenefitRelDTOAssembler.toDTO(domain);
    }
}
