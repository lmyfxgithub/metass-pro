package top.metass.pro.module.member.convert.user;

import java.util.*;

import top.metass.pro.framework.common.pojo.PageResult;

import top.metass.pro.module.member.controller.app.user.vo.AppMemberUserGptRespVO;
import top.metass.pro.module.member.controller.app.user.vo.AppUserInfoRespVO;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.metass.pro.module.member.controller.admin.user.vo.*;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserGptDO;

/**
 * 会员gpt扩展 Convert
 *
 * @author 三生
 */
@Mapper
public interface MemberUserGptConvert {

    MemberUserGptConvert INSTANCE = Mappers.getMapper(MemberUserGptConvert.class);

    MemberUserGptDO convert(MemberUserGptCreateReqVO bean);

    MemberUserGptDO convert(MemberUserGptUpdateReqVO bean);

    MemberUserGptRespVO convert2(MemberUserGptDO bean);

    List<MemberUserGptRespVO> convertList(List<MemberUserGptDO> list);

    PageResult<MemberUserGptRespVO> convertPage(PageResult<MemberUserGptDO> page);

    List<MemberUserGptExcelVO> convertList02(List<MemberUserGptDO> list);

    AppMemberUserGptRespVO convert(MemberUserGptDO bean);
    MemberUserGptUpdateReqVO convert3(MemberUserGptDO bean);

}
