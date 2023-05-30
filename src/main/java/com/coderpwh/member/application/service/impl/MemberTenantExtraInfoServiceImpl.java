package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.command.MemberTenantExtraInfoCommand;
import com.coderpwh.member.application.command.MemberTenantExtraInfoQuery;
import com.coderpwh.member.application.assembler.domain.MemberTenantExtraInfoDTOAssembler;
import com.coderpwh.member.application.service.MemberTenantExtraInfoService;
import com.coderpwh.member.infrastructure.persistence.entity.MemberTenantExtraInfoDO;
import javax.annotation.Resource;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberTenantExtraInfoMapper;
import java.util.List;
import cn.hutool.core.collection.CollUtil;
import com.coderpwh.member.domain.model.MemberTenantExtraInfo;
import org.springframework.stereotype.Service;
import com.coderpwh.member.domain.model.MemberTenantExtraInfoRepository;
import com.coderpwh.member.application.assembler.command.MemberTenantExtraInfoAssembler;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.application.dto.MemberTenantExtraInfoDTO;

/**
 * <p>
 * 租户额外信息表 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Service
public class MemberTenantExtraInfoServiceImpl extends ServiceImpl<MemberTenantExtraInfoMapper, MemberTenantExtraInfoDO> implements MemberTenantExtraInfoService {

    @Resource
    private MemberTenantExtraInfoRepository memberTenantExtraInfoRepository;
    @Resource
    private MemberTenantExtraInfoAssembler memberTenantExtraInfoAssembler;
    @Resource
    private MemberTenantExtraInfoDTOAssembler memberTenantExtraInfoDTOAssembler;



    @Override
    public PageUtils queryPage(MemberTenantExtraInfoQuery query) {
        // 查询分页数据
        PageUtils pageUtils = memberTenantExtraInfoRepository.queryPage(query);
        List<MemberTenantExtraInfo> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<MemberTenantExtraInfoDTO> dtoList = memberTenantExtraInfoDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(MemberTenantExtraInfoCommand memberTenantExtraInfoCommand){
        MemberTenantExtraInfo domain = memberTenantExtraInfoAssembler.toEntity(memberTenantExtraInfoCommand);
        return memberTenantExtraInfoRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return memberTenantExtraInfoRepository.deleteById(id);
    }

    @Override
    public boolean updateById(MemberTenantExtraInfoCommand memberTenantExtraInfoCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (memberTenantExtraInfoCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberTenantExtraInfo domain = memberTenantExtraInfoAssembler.toEntity(memberTenantExtraInfoCommand);
        return memberTenantExtraInfoRepository.updateById(domain);
    }

    @Override
    public MemberTenantExtraInfoDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberTenantExtraInfo domain = memberTenantExtraInfoRepository.getById(id);
        return memberTenantExtraInfoDTOAssembler.toDTO(domain);
    }
}
