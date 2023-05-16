package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.command.MemberCardHistoryCommand;
import com.coderpwh.member.application.service.MemberCardHistoryService;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.MemberCardHistoryRepository;
import javax.annotation.Resource;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCardHistoryDO;
import com.coderpwh.member.domain.model.MemberCardHistory;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberCardHistoryMapper;

import java.util.List;
import cn.hutool.core.collection.CollUtil;
import com.coderpwh.member.application.command.MemberCardHistoryQuery;
import org.springframework.stereotype.Service;
import com.coderpwh.member.application.assembler.domain.MemberCardHistoryDTOAssembler;
import com.coderpwh.member.application.assembler.command.MemberCardHistoryAssembler;
import com.coderpwh.member.application.dto.MemberCardHistoryDTO;

/**
 * <p>
 * 用户卡历史 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Service
public class MemberCardHistoryServiceImpl extends ServiceImpl<MemberCardHistoryMapper, MemberCardHistoryDO> implements MemberCardHistoryService {

    @Resource
    private MemberCardHistoryRepository memberCardHistoryRepository;
    @Resource
    private MemberCardHistoryAssembler memberCardHistoryAssembler;
    @Resource
    private MemberCardHistoryDTOAssembler memberCardHistoryDTOAssembler;



    @Override
    public PageUtils queryPage(MemberCardHistoryQuery query) {
        // 查询分页数据
        PageUtils pageUtils = memberCardHistoryRepository.queryPage(query);
        List<MemberCardHistory> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<MemberCardHistoryDTO> dtoList = memberCardHistoryDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(MemberCardHistoryCommand memberCardHistoryCommand){
        MemberCardHistory domain = memberCardHistoryAssembler.toEntity(memberCardHistoryCommand);
        return memberCardHistoryRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return memberCardHistoryRepository.deleteById(id);
    }

    @Override
    public boolean updateById(MemberCardHistoryCommand memberCardHistoryCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (memberCardHistoryCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberCardHistory domain = memberCardHistoryAssembler.toEntity(memberCardHistoryCommand);
        return memberCardHistoryRepository.updateById(domain);
    }

    @Override
    public MemberCardHistoryDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberCardHistory domain = memberCardHistoryRepository.getById(id);
        return memberCardHistoryDTOAssembler.toDTO(domain);
    }
}
