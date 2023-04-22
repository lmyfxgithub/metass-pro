package top.metass.pro.module.member.convert.user;

import java.util.*;

import top.metass.pro.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.metass.pro.module.member.controller.admin.user.vo.*;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserDO;

/**
 * 用户 Convert
 *
 * @author 三生
 */
@Mapper
public interface MemberUserConvert {

    MemberUserConvert INSTANCE = Mappers.getMapper(MemberUserConvert.class);

    MemberUserDO convert(MemberUserCreateReqVO bean);

    MemberUserDO convert(MemberUserUpdateReqVO bean);

    MemberUserRespVO convert(MemberUserDO bean);

    List<MemberUserRespVO> convertList(List<MemberUserDO> list);

    PageResult<MemberUserRespVO> convertPage(PageResult<MemberUserDO> page);

    List<MemberUserExcelVO> convertList02(List<MemberUserDO> list);

}
