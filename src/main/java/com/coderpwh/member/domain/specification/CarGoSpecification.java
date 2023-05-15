package com.coderpwh.member.domain.specification;


import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.coderpwh.member.common.ddd.AbstractSpecification;
import com.coderpwh.member.common.util.enums.DddEnum;
import com.coderpwh.member.common.util.enums.SysReturnCode;
import com.coderpwh.member.common.util.exception.BusinessException;
import com.coderpwh.member.domain.model.CarGoRepository;
import com.coderpwh.member.domain.model.CargoBook;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author coderpwh
 * @date 2023/4/28 9:55
 */
@AllArgsConstructor
@NoArgsConstructor
public class CarGoSpecification extends AbstractSpecification<Integer> {

    private CarGoRepository carGoRepository;

    @Override
    public boolean isSatisfiedBy(Integer var1) {
        return false;
    }

    /***
     * 校验
     * @param senderPhone
     * @return
     */
    public boolean isGarGo(String senderPhone) {

        CargoBook cargoBook = carGoRepository.getBySenderPhone(senderPhone);

        if (ObjectUtils.isEmpty(cargoBook)) {
            return true;
        } else {
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前编码已存在");
        }

    }


    /***
     * 通过senderPhone校验
     * @param senderPhone
     */
    public Boolean isSenderPhone(String senderPhone) {
        CargoBook cargoBook = carGoRepository.getBySenderPhone(senderPhone);

        if (ObjectUtils.isEmpty(cargoBook)) {
            throw new BusinessException(SysReturnCode.CarGo, DddEnum.APPLICATIN, "当前编码不不存在");
        } else {
            return true;
        }

    }

}
