package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javax.annotation.Resource;
import com.coderpwh.member.application.dto.MemberCardDTO;
import com.coderpwh.member.application.service.MemberCardService;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.MemberCardRepository;
import com.coderpwh.member.application.command.MemberCardQuery;
import com.coderpwh.member.application.command.MemberCardCommand;
import java.util.List;
import cn.hutool.core.collection.CollUtil;
import com.coderpwh.member.application.assembler.command.MemberCardAssembler;
import com.coderpwh.member.domain.model.MemberCard;
import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.mapper.MemberCardMapper;
import com.coderpwh.member.infrastructure.persistence.entity.MemberCardDO;
import com.coderpwh.member.application.assembler.domain.MemberCardDTOAssembler;

/**
 * <p>
 * 用户卡信息 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Service
public class MemberCardServiceImpl  implements MemberCardService {

    @Resource
    private MemberCardRepository memberCardRepository;
    @Resource
    private MemberCardAssembler memberCardAssembler;
    @Resource
    private MemberCardDTOAssembler memberCardDTOAssembler;



    @Override
    public PageUtils queryPage(MemberCardQuery query) {
        // 查询分页数据
        PageUtils pageUtils = memberCardRepository.queryPage(query);
        List<MemberCard> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<MemberCardDTO> dtoList = memberCardDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(MemberCardCommand memberCardCommand){
        MemberCard domain = memberCardAssembler.toEntity(memberCardCommand);
        return memberCardRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return memberCardRepository.deleteById(id);
    }

    @Override
    public boolean updateById(MemberCardCommand memberCardCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (memberCardCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberCard domain = memberCardAssembler.toEntity(memberCardCommand);
        return memberCardRepository.updateById(domain);
    }

    @Override
    public MemberCardDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberCard domain = memberCardRepository.getById(id);
        return memberCardDTOAssembler.toDTO(domain);
    }
}
