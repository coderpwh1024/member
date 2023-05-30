package com.coderpwh.member.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderpwh.member.application.dto.OrderOrderExtraInfoDTO;
import com.coderpwh.member.application.command.OrderOrderExtraInfoQuery;
import com.coderpwh.member.application.assembler.domain.OrderOrderExtraInfoDTOAssembler;
import com.coderpwh.member.application.service.OrderOrderExtraInfoService;
import com.coderpwh.member.domain.model.OrderOrderExtraInfoRepository;
import javax.annotation.Resource;
import com.coderpwh.member.application.assembler.command.OrderOrderExtraInfoAssembler;
import java.util.List;
import cn.hutool.core.collection.CollUtil;
import com.coderpwh.member.application.command.OrderOrderExtraInfoCommand;
import org.springframework.stereotype.Service;
import com.coderpwh.member.infrastructure.persistence.mapper.OrderOrderExtraInfoMapper;
import com.coderpwh.member.infrastructure.persistence.entity.OrderOrderExtraInfoDO;
import com.coderpwh.member.domain.model.OrderOrderExtraInfo;
import com.coderpwh.member.common.database.PageUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author coderpwh
 * @since 2023-05-30
 */
@Service
public class OrderOrderExtraInfoServiceImpl extends ServiceImpl<OrderOrderExtraInfoMapper, OrderOrderExtraInfoDO> implements OrderOrderExtraInfoService {

    @Resource
    private OrderOrderExtraInfoRepository orderOrderExtraInfoRepository;
    @Resource
    private OrderOrderExtraInfoAssembler orderOrderExtraInfoAssembler;
    @Resource
    private OrderOrderExtraInfoDTOAssembler orderOrderExtraInfoDTOAssembler;



    @Override
    public PageUtils queryPage(OrderOrderExtraInfoQuery query) {
        // 查询分页数据
        PageUtils pageUtils = orderOrderExtraInfoRepository.queryPage(query);
        List<OrderOrderExtraInfo> list = pageUtils.getList();
        if (CollUtil.isNotEmpty(list)) {
            //领域对象集合数据转换为DTO输出数据
            List<OrderOrderExtraInfoDTO> dtoList = orderOrderExtraInfoDTOAssembler.toDTO(list);
            pageUtils.setList(dtoList);
        }
        return pageUtils;
    }


    @Override
    public boolean save(OrderOrderExtraInfoCommand orderOrderExtraInfoCommand){
        OrderOrderExtraInfo domain = orderOrderExtraInfoAssembler.toEntity(orderOrderExtraInfoCommand);
        return orderOrderExtraInfoRepository.save(domain);
    }

    @Override
    public boolean deleteById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        return orderOrderExtraInfoRepository.deleteById(id);
    }

    @Override
    public boolean updateById(OrderOrderExtraInfoCommand orderOrderExtraInfoCommand){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (orderOrderExtraInfoCommand.getId() == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        OrderOrderExtraInfo domain = orderOrderExtraInfoAssembler.toEntity(orderOrderExtraInfoCommand);
        return orderOrderExtraInfoRepository.updateById(domain);
    }

    @Override
    public OrderOrderExtraInfoDTO getById(Integer id){
        // 如果id为null 为了安全考虑，则不执行，返回提示
        if (id == null) {
            //根据需要改成抛出BusinessException异常
//            throw new Exception("Id不能为空!");
        }
        OrderOrderExtraInfo domain = orderOrderExtraInfoRepository.getById(id);
        return orderOrderExtraInfoDTOAssembler.toDTO(domain);
    }
}
