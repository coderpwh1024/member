package com.coderpwh.member.application.service.impl;
import com.coderpwh.member.application.service.MemberUserService;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.MemberUser;
import com.coderpwh.member.application.command.MemberUserCommand;
import com.coderpwh.member.domain.model.MemberUserRepository;
import javax.annotation.Resource;
import com.coderpwh.member.application.assembler.domain.MemberUserDTOAssembler;
import com.coderpwh.member.application.command.MemberUserQuery;
import java.util.List;
import cn.hutool.core.collection.CollUtil;
import com.coderpwh.member.application.dto.MemberUserDTO;
import org.springframework.stereotype.Service;
import com.coderpwh.member.application.assembler.command.MemberUserAssembler;


/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-16
 */
@Service
public class MemberUserServiceImpl   implements MemberUserService {

    @Resource
    private MemberUserRepository memberUserRepository;
    @Resource
    private MemberUserAssembler memberUserAssembler;
    @Resource
    private MemberUserDTOAssembler memberUserDTOAssembler;



    @Override
    public PageUtils queryPage(MemberUserQuery query) {
        // 查询分页数据
        PageUtils pageUtils = memberUserRepository.queryPage(query);
        List<MemberUser> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<MemberUserDTO> dtoList = memberUserDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(MemberUserCommand memberUserCommand){
        MemberUser domain = memberUserAssembler.toEntity(memberUserCommand);
        return memberUserRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return memberUserRepository.deleteById(id);
    }

    @Override
    public boolean updateById(MemberUserCommand memberUserCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (memberUserCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberUser domain = memberUserAssembler.toEntity(memberUserCommand);
        return memberUserRepository.updateById(domain);
    }

    @Override
    public MemberUserDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        MemberUser domain = memberUserRepository.getById(id);
        return memberUserDTOAssembler.toDTO(domain);
    }
}
