package top.metass.pro.module.member.dal.mysql.user;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.mybatis.core.mapper.BaseMapperX;
import top.metass.pro.framework.mybatis.core.query.LambdaQueryWrapperX;
import top.metass.pro.module.member.controller.admin.user.vo.MemberUserExportReqVO;
import top.metass.pro.module.member.controller.admin.user.vo.MemberUserPageReqVO;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 会员 User Mapper
 *
 * @author 三生宇宙
 */
@Mapper
public interface MemberUserMapper extends BaseMapperX<MemberUserDO> {

    default MemberUserDO selectByMobile(String mobile) {
        return selectOne(MemberUserDO::getMobile, mobile);
    }

    default List<MemberUserDO> selectListByNicknameLike(String nickname) {
        return selectList(new LambdaQueryWrapperX<MemberUserDO>()
                .likeIfPresent(MemberUserDO::getNickname, nickname));
    }

    default PageResult<MemberUserDO> selectPage(MemberUserPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MemberUserDO>()
                .likeIfPresent(MemberUserDO::getNickname, reqVO.getNickname())
                .eqIfPresent(MemberUserDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(MemberUserDO::getStatus, reqVO.getStatus())
                .eqIfPresent(MemberUserDO::getMobile, reqVO.getMobile())
                .eqIfPresent(MemberUserDO::getPassword, reqVO.getPassword())
                .eqIfPresent(MemberUserDO::getRegisterIp, reqVO.getRegisterIp())
                .eqIfPresent(MemberUserDO::getLoginIp, reqVO.getLoginIp())
                .betweenIfPresent(MemberUserDO::getLoginDate, reqVO.getLoginDate())
                .betweenIfPresent(MemberUserDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberUserDO::getId));
    }

    default List<MemberUserDO> selectList(MemberUserExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MemberUserDO>()
                .likeIfPresent(MemberUserDO::getNickname, reqVO.getNickname())
                .eqIfPresent(MemberUserDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(MemberUserDO::getStatus, reqVO.getStatus())
                .eqIfPresent(MemberUserDO::getMobile, reqVO.getMobile())
                .eqIfPresent(MemberUserDO::getPassword, reqVO.getPassword())
                .eqIfPresent(MemberUserDO::getRegisterIp, reqVO.getRegisterIp())
                .eqIfPresent(MemberUserDO::getLoginIp, reqVO.getLoginIp())
                .betweenIfPresent(MemberUserDO::getLoginDate, reqVO.getLoginDate())
                .betweenIfPresent(MemberUserDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberUserDO::getId));
    }

}
