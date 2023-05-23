package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.command.MemberCallbackConfigCommand;
import javax.annotation.Resource;
import com.coderpwh.member.application.dto.MemberCallbackConfigDTO;
import com.coderpwh.member.application.service.MemberCallbackConfigService;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.MemberCallbackConfig;
import com.coderpwh.member.domain.model.MemberCallbackConfigRepository;
import java.util.List;
import com.coderpwh.member.application.assembler.command.MemberCallbackConfigAssembler;
import cn.hutool.core.collection.CollUtil;
import com.coderpwh.member.application.command.MemberCallbackConfigQuery;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCallbackConfigDO;
import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberCallbackConfigMapper;
import com.coderpwh.member.application.assembler.domain.MemberCallbackConfigDTOAssembler;

/**
 * <p>
 * 回调配置 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-23
 */
@Service
public class MemberCallbackConfigServiceImpl extends ServiceImpl<MemberCallbackConfigMapper, MemberCallbackConfigDO> implements MemberCallbackConfigService {

    @Resource
    private MemberCallbackConfigRepository memberCallbackConfigRepository;
    @Resource
    private MemberCallbackConfigAssembler memberCallbackConfigAssembler;
    @Resource
    private MemberCallbackConfigDTOAssembler memberCallbackConfigDTOAssembler;



    @Override
    public PageUtils queryPage(MemberCallbackConfigQuery query) {
        // 查询分页数据
        PageUtils pageUtils = memberCallbackConfigRepository.queryPage(query);
        List<MemberCallbackConfig> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<MemberCallbackConfigDTO> dtoList = memberCallbackConfigDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(MemberCallbackConfigCommand memberCallbackConfigCommand){
        MemberCallbackConfig domain = memberCallbackConfigAssembler.toEntity(memberCallbackConfigCommand);
        return memberCallbackConfigRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return memberCallbackConfigRepository.deleteById(id);
    }

    @Override
    public boolean updateById(MemberCallbackConfigCommand memberCallbackConfigCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (memberCallbackConfigCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberCallbackConfig domain = memberCallbackConfigAssembler.toEntity(memberCallbackConfigCommand);
        return memberCallbackConfigRepository.updateById(domain);
    }

    @Override
    public MemberCallbackConfigDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberCallbackConfig domain = memberCallbackConfigRepository.getById(id);
        return memberCallbackConfigDTOAssembler.toDTO(domain);
    }
}
