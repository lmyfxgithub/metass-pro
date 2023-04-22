package top.metass.pro.module.pay.convert.merchant;

import java.util.*;

import top.metass.pro.framework.common.pojo.PageResult;

import top.metass.pro.module.pay.controller.admin.merchant.vo.merchant.PayMerchantCreateReqVO;
import top.metass.pro.module.pay.controller.admin.merchant.vo.merchant.PayMerchantExcelVO;
import top.metass.pro.module.pay.controller.admin.merchant.vo.merchant.PayMerchantRespVO;
import top.metass.pro.module.pay.controller.admin.merchant.vo.merchant.PayMerchantUpdateReqVO;
import top.metass.pro.module.pay.dal.dataobject.merchant.PayMerchantDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayMerchantConvert {

    PayMerchantConvert INSTANCE = Mappers.getMapper(PayMerchantConvert.class);

    PayMerchantDO convert(PayMerchantCreateReqVO bean);

    PayMerchantDO convert(PayMerchantUpdateReqVO bean);

    PayMerchantRespVO convert(PayMerchantDO bean);

    List<PayMerchantRespVO> convertList(List<PayMerchantDO> list);

    PageResult<PayMerchantRespVO> convertPage(PageResult<PayMerchantDO> page);

    List<PayMerchantExcelVO> convertList02(List<PayMerchantDO> list);

}
