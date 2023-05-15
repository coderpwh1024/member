package com.coderpwh.member.domain.service;


import com.coderpwh.member.application.assembler.domain.CargoBookDTOAssembler;
import com.coderpwh.member.application.assembler.vo.CargoBookVOAssembler;
import com.coderpwh.member.application.command.CargoBookPageQuery;
import com.coderpwh.member.application.dto.CargoBookDTO;
import com.coderpwh.member.application.vo.CarGoBookVO;
import com.coderpwh.member.common.database.PageUtils;
import com.coderpwh.member.domain.model.CarGoRepository;
import com.coderpwh.member.domain.model.CargoBook;

import java.util.List;

/**
 * 领域层
 *
 * @author coderpwh
 * @date 2023/4/27 16:27
 */
public class DomainCarGoService {
    private CarGoRepository carGoRepository;

    private CargoBookDTOAssembler cargoBookDTOAssembler;

    private CargoBookVOAssembler cargoBookVOAssembler;


    /***
     * 新增时调用
     * @param repository
     * @param cargoBookDTOAssembler
     * @param cargoBookVOAssembler
     */
    public DomainCarGoService(CarGoRepository repository, CargoBookDTOAssembler cargoBookDTOAssembler, CargoBookVOAssembler cargoBookVOAssembler) {
        this.carGoRepository = repository;
        this.cargoBookDTOAssembler = cargoBookDTOAssembler;
        this.cargoBookVOAssembler = cargoBookVOAssembler;
    }


    /***
     * 新增时领域函数
     * @param repository
     */
    public DomainCarGoService(CarGoRepository repository) {
        this.carGoRepository = repository;
    }

    /***
     *  保存
     * @param domain
     * @return
     */
    public Boolean save(CargoBook domain) {
        return carGoRepository.save(domain);
    }


    /***
     * 查询
     * @param senderPhone
     * @return
     */
    public CarGoBookVO queryCargoBook(String senderPhone) {

        CargoBook cargoBook = carGoRepository.getBySenderPhone(senderPhone);

        CargoBookDTO cargoBookDTO = cargoBookDTOAssembler.toDTO(cargoBook);

        CarGoBookVO carGoBookVO = cargoBookVOAssembler.toDTO(cargoBookDTO);

        return carGoBookVO;
    }


    /***
     * 分页查询
     * @param query
     * @return
     */
    public PageUtils queryCargoBookPage(CargoBookPageQuery query) {
        // 分页参数
        PageUtils pageUtils = carGoRepository.queryByPage(query);
        List<CargoBook> list = pageUtils.getList();
        // 转换
        List<CargoBookDTO> cargoBookDTOList = cargoBookDTOAssembler.toDTO(list);
        List<CarGoBookVO> carGoBookVOList = cargoBookVOAssembler.toDTO(cargoBookDTOList);

        pageUtils.setList(carGoBookVOList);
        return pageUtils;
    }
}
