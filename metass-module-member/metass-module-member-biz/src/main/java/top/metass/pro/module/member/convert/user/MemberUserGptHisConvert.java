package top.metass.pro.module.member.convert.user;

import java.util.*;

import top.metass.pro.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.metass.pro.module.member.controller.admin.user.vo.*;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserGptHisDO;

/**
 * 会员gpt扩展历史 Convert
 *
 * @author 三生
 */
@Mapper
public interface MemberUserGptHisConvert {

    MemberUserGptHisConvert INSTANCE = Mappers.getMapper(MemberUserGptHisConvert.class);

    MemberUserGptHisDO convert(MemberUserGptHisCreateReqVO bean);

    MemberUserGptHisDO convert(MemberUserGptHisUpdateReqVO bean);

    MemberUserGptHisRespVO convert(MemberUserGptHisDO bean);

    List<MemberUserGptHisRespVO> convertList(List<MemberUserGptHisDO> list);

    PageResult<MemberUserGptHisRespVO> convertPage(PageResult<MemberUserGptHisDO> page);

    List<MemberUserGptHisExcelVO> convertList02(List<MemberUserGptHisDO> list);

}
