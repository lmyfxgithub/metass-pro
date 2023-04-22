package top.metass.pro.module.member.dal.mysql.user;

import java.util.*;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.mybatis.core.query.LambdaQueryWrapperX;
import top.metass.pro.framework.mybatis.core.mapper.BaseMapperX;
import top.metass.pro.module.member.convert.user.MemberUserGptConvert;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserDO;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserGptDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import top.metass.pro.module.member.controller.admin.user.vo.*;

/**
 * 会员gpt扩展 Mapper
 *
 * @author 三生
 */
@Mapper
public interface MemberUserGptMapper extends BaseMapperX<MemberUserGptDO> {

    default PageResult<MemberUserGptDO> selectPage(MemberUserGptPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MemberUserGptDO>()
                .eqIfPresent(MemberUserGptDO::getUserId, reqVO.getUserId())
                .eqIfPresent(MemberUserGptDO::getMobile, reqVO.getMobile())
                .eqIfPresent(MemberUserGptDO::getVipType, reqVO.getVipType())
                .eqIfPresent(MemberUserGptDO::getVipExpires, reqVO.getVipExpires())
                .eqIfPresent(MemberUserGptDO::getIntegral, reqVO.getIntegral())
                .eqIfPresent(MemberUserGptDO::getParm1, reqVO.getParm1())
                .eqIfPresent(MemberUserGptDO::getParm2, reqVO.getParm2())
                .eqIfPresent(MemberUserGptDO::getParmJson, reqVO.getParmJson())
                .eqIfPresent(MemberUserGptDO::getRevision, reqVO.getRevision())
                .betweenIfPresent(MemberUserGptDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberUserGptDO::getId));
    }

    default List<MemberUserGptDO> selectList(MemberUserGptExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MemberUserGptDO>()
                .eqIfPresent(MemberUserGptDO::getUserId, reqVO.getUserId())
                .eqIfPresent(MemberUserGptDO::getMobile, reqVO.getMobile())
                .eqIfPresent(MemberUserGptDO::getVipType, reqVO.getVipType())
                .eqIfPresent(MemberUserGptDO::getVipExpires, reqVO.getVipExpires())
                .eqIfPresent(MemberUserGptDO::getIntegral, reqVO.getIntegral())
                .eqIfPresent(MemberUserGptDO::getParm1, reqVO.getParm1())
                .eqIfPresent(MemberUserGptDO::getParm2, reqVO.getParm2())
                .eqIfPresent(MemberUserGptDO::getParmJson, reqVO.getParmJson())
                .eqIfPresent(MemberUserGptDO::getRevision, reqVO.getRevision())
                .betweenIfPresent(MemberUserGptDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberUserGptDO::getId));
    }

    default MemberUserGptDO selectByUserId(Long userId) {
        return selectOne(new QueryWrapper<MemberUserGptDO>().eq("user_id", userId));
    }

}
