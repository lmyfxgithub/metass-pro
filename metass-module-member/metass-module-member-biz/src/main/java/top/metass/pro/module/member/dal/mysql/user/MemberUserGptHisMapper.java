package top.metass.pro.module.member.dal.mysql.user;

import java.util.*;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.mybatis.core.query.LambdaQueryWrapperX;
import top.metass.pro.framework.mybatis.core.mapper.BaseMapperX;
import top.metass.pro.module.member.dal.dataobject.user.MemberUserGptHisDO;
import org.apache.ibatis.annotations.Mapper;
import top.metass.pro.module.member.controller.admin.user.vo.*;

/**
 * 会员gpt扩展历史 Mapper
 *
 * @author 三生
 */
@Mapper
public interface MemberUserGptHisMapper extends BaseMapperX<MemberUserGptHisDO> {

    default PageResult<MemberUserGptHisDO> selectPage(MemberUserGptHisPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MemberUserGptHisDO>()
                .eqIfPresent(MemberUserGptHisDO::getUserId, reqVO.getUserId())
                .eqIfPresent(MemberUserGptHisDO::getActive, reqVO.getActive())
                .eqIfPresent(MemberUserGptHisDO::getConut, reqVO.getConut())
                .eqIfPresent(MemberUserGptHisDO::getParm1, reqVO.getParm1())
                .eqIfPresent(MemberUserGptHisDO::getParm2, reqVO.getParm2())
                .eqIfPresent(MemberUserGptHisDO::getRemark, reqVO.getRemark())
                .eqIfPresent(MemberUserGptHisDO::getRevision, reqVO.getRevision())
                .betweenIfPresent(MemberUserGptHisDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberUserGptHisDO::getId));
    }

    default List<MemberUserGptHisDO> selectList(MemberUserGptHisExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MemberUserGptHisDO>()
                .eqIfPresent(MemberUserGptHisDO::getUserId, reqVO.getUserId())
                .eqIfPresent(MemberUserGptHisDO::getActive, reqVO.getActive())
                .eqIfPresent(MemberUserGptHisDO::getConut, reqVO.getConut())
                .eqIfPresent(MemberUserGptHisDO::getParm1, reqVO.getParm1())
                .eqIfPresent(MemberUserGptHisDO::getParm2, reqVO.getParm2())
                .eqIfPresent(MemberUserGptHisDO::getRemark, reqVO.getRemark())
                .eqIfPresent(MemberUserGptHisDO::getRevision, reqVO.getRevision())
                .betweenIfPresent(MemberUserGptHisDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberUserGptHisDO::getId));
    }

}
