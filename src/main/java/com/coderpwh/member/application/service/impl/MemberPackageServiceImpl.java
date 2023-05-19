package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.assembler.domain.MemberPackageDTOAssembler;
import com.coderpwh.member.application.service.MemberPackageService;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.MemberPackageRepository;
import javax.annotation.Resource;
import java.util.List;
import com.coderpwh.member.application.assembler.command.MemberPackageAssembler;
import cn.hutool.core.collection.CollUtil;
import com.coderpwh.member.application.dto.MemberPackageDTO;
import com.coderpwh.member.domain.model.MemberPackage;
import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.entity.MemberPackageDO;
import com.coderpwh.member.application.command.MemberPackageQuery;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberPackageMapper;
import com.coderpwh.member.application.command.MemberPackageCommand;

/**
 * <p>
 * 会员套餐包 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-19
 */
@Service
public class MemberPackageServiceImpl extends ServiceImpl<MemberPackageMapper, MemberPackageDO> implements MemberPackageService {

    @Resource
    private MemberPackageRepository memberPackageRepository;
    @Resource
    private MemberPackageAssembler memberPackageAssembler;
    @Resource
    private MemberPackageDTOAssembler memberPackageDTOAssembler;



    @Override
    public PageUtils queryPage(MemberPackageQuery query) {
        // 查询分页数据
        PageUtils pageUtils = memberPackageRepository.queryPage(query);
        List<MemberPackage> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<MemberPackageDTO> dtoList = memberPackageDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(MemberPackageCommand memberPackageCommand){
        MemberPackage domain = memberPackageAssembler.toEntity(memberPackageCommand);
        return memberPackageRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return memberPackageRepository.deleteById(id);
    }

    @Override
    public boolean updateById(MemberPackageCommand memberPackageCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (memberPackageCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberPackage domain = memberPackageAssembler.toEntity(memberPackageCommand);
        return memberPackageRepository.updateById(domain);
    }

    @Override
    public MemberPackageDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberPackage domain = memberPackageRepository.getById(id);
        return memberPackageDTOAssembler.toDTO(domain);
    }
}
