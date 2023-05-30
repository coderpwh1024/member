package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.assembler.domain.MemberTenantExtraPropertyDTOAssembler;
import javax.annotation.Resource;

import com.coderpwh.member.application.service.MemberTenantExtraPropertyService;
import com.coderpwh.member.domain.model.MemberTenantExtraPropertyRepository;
import com.coderpwh.member.application.dto.MemberTenantExtraPropertyDTO;
import com.coderpwh.member.domain.model.MemberTenantExtraProperty;
import com.coderpwh.member.application.assembler.command.MemberTenantExtraPropertyAssembler;
import java.util.List;
import cn.hutool.core.collection.CollUtil;
import com.coderpwh.member.application.command.MemberTenantExtraPropertyCommand;
import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantExtraPropertyDO;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberTenantExtraPropertyMapper;
import com.coderpwh.member.application.command.MemberTenantExtraPropertyQuery;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 * 租户额外属性表 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Service
public class MemberTenantExtraPropertyServiceImpl extends ServiceImpl<MemberTenantExtraPropertyMapper, MemberTenantExtraPropertyDO> implements MemberTenantExtraPropertyService {

    @Resource
    private MemberTenantExtraPropertyRepository memberTenantExtraPropertyRepository;
    @Resource
    private MemberTenantExtraPropertyAssembler memberTenantExtraPropertyAssembler;
    @Resource
    private MemberTenantExtraPropertyDTOAssembler memberTenantExtraPropertyDTOAssembler;



    @Override
    public PageUtils queryPage(MemberTenantExtraPropertyQuery query) {
        // 查询分页数据
        PageUtils pageUtils = memberTenantExtraPropertyRepository.queryPage(query);
        List<MemberTenantExtraProperty> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<MemberTenantExtraPropertyDTO> dtoList = memberTenantExtraPropertyDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(MemberTenantExtraPropertyCommand memberTenantExtraPropertyCommand){
        MemberTenantExtraProperty domain = memberTenantExtraPropertyAssembler.toEntity(memberTenantExtraPropertyCommand);
        return memberTenantExtraPropertyRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return memberTenantExtraPropertyRepository.deleteById(id);
    }

    @Override
    public boolean updateById(MemberTenantExtraPropertyCommand memberTenantExtraPropertyCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (memberTenantExtraPropertyCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberTenantExtraProperty domain = memberTenantExtraPropertyAssembler.toEntity(memberTenantExtraPropertyCommand);
        return memberTenantExtraPropertyRepository.updateById(domain);
    }

    @Override
    public MemberTenantExtraPropertyDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberTenantExtraProperty domain = memberTenantExtraPropertyRepository.getById(id);
        return memberTenantExtraPropertyDTOAssembler.toDTO(domain);
    }
}
