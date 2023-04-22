package top.metass.pro.module.member.convert.address;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.member.api.address.dto.AddressRespDTO;
import top.metass.pro.module.member.controller.app.address.vo.AppAddressCreateReqVO;
import top.metass.pro.module.member.controller.app.address.vo.AppAddressRespVO;
import top.metass.pro.module.member.controller.app.address.vo.AppAddressUpdateReqVO;
import top.metass.pro.module.member.dal.dataobject.address.AddressDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户收件地址 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface AddressConvert {

    AddressConvert INSTANCE = Mappers.getMapper(AddressConvert.class);

    AddressDO convert(AppAddressCreateReqVO bean);

    AddressDO convert(AppAddressUpdateReqVO bean);

    AppAddressRespVO convert(AddressDO bean);

    List<AppAddressRespVO> convertList(List<AddressDO> list);

    PageResult<AppAddressRespVO> convertPage(PageResult<AddressDO> page);

    AddressRespDTO convert02(AddressDO bean);

}
