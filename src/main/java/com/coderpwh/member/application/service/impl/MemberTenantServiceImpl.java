package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.service.MemberTenantService;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberTenantMapper;
import com.coderpwh.member.domain.model.MemberTenantRepository;
import com.coderpwh.member.domain.model.MemberTenant;
import javax.annotation.Resource;

import com.coderpwh.member.application.assembler.command.MemberTenantAssembler;
import com.coderpwh.member.application.command.MemberTenantCommand;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantDO;
import java.util.List;
import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Service;
import com.coderpwh.member.application.dto.MemberTenantDTO;
import com.coderpwh.member.application.assembler.domain.MemberTenantDTOAssembler;
import com.coderpwh.member.application.command.MemberTenantQuery;

/**
 * <p>
 * 租户空间 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Service
public class MemberTenantServiceImpl  implements MemberTenantService {

    @Resource
    private MemberTenantRepository memberTenantRepository;
    @Resource
    private MemberTenantAssembler memberTenantAssembler;
    @Resource
    private MemberTenantDTOAssembler memberTenantDTOAssembler;



    @Override
    public PageUtils queryPage(MemberTenantQuery query) {
        // 查询分页数据
        PageUtils pageUtils = memberTenantRepository.queryPage(query);
        List<MemberTenant> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<MemberTenantDTO> dtoList = memberTenantDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(MemberTenantCommand memberTenantCommand){
        MemberTenant domain = memberTenantAssembler.toEntity(memberTenantCommand);
        return memberTenantRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return memberTenantRepository.deleteById(id);
    }

    @Override
    public boolean updateById(MemberTenantCommand memberTenantCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (memberTenantCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberTenant domain = memberTenantAssembler.toEntity(memberTenantCommand);
        return memberTenantRepository.updateById(domain);
    }

    @Override
    public MemberTenantDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberTenant domain = memberTenantRepository.getById(id);
        return memberTenantDTOAssembler.toDTO(domain);
    }
}
