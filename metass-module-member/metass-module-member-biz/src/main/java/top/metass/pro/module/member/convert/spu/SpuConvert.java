package top.metass.pro.module.member.convert.spu;

import java.util.*;

import top.metass.pro.framework.common.pojo.PageResult;

import top.metass.pro.module.member.api.spu.dto.MemberSpuRespDTO;
import top.metass.pro.module.member.api.user.dto.MemberUserRespDTO;
import top.metass.pro.module.member.controller.app.spu.vo.*;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.metass.pro.module.member.controller.admin.spu.vo.*;
import top.metass.pro.module.member.dal.dataobject.spu.SpuDO;

/**
 * 会员商品 Convert
 *
 * @author 三生
 */
@Mapper
public interface SpuConvert {

    SpuConvert INSTANCE = Mappers.getMapper(SpuConvert.class);

    SpuDO convert(SpuCreateReqVO bean);

    SpuDO convert(SpuUpdateReqVO bean);
    SpuDO convert(MemberSpuRespDTO bean);

    SpuRespVO convert(SpuDO bean);

    List<SpuRespVO> convertList(List<SpuDO> list);

    PageResult<SpuRespVO> convertPage(PageResult<SpuDO> page);

    List<SpuExcelVO> convertList02(List<SpuDO> list);

    SpuDO convert(AppSpuCreateReqVO bean);

    SpuDO convert(AppSpuReqVO bean);

    AppSpuRespVO convert2(SpuDO bean);

    List<AppSpuRespVO> convertList2(List<SpuDO> list);

    PageResult<AppSpuRespVO> convertPage2(PageResult<SpuDO> page);


    MemberSpuRespDTO convert3(SpuDO bean);
    List<MemberSpuRespDTO> convertList03(List<SpuDO> list);

}
