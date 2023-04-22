package top.metass.pro.module.bpm.convert.definition;

import java.util.*;

import top.metass.pro.module.bpm.controller.admin.definition.vo.group.BpmUserGroupCreateReqVO;
import top.metass.pro.module.bpm.controller.admin.definition.vo.group.BpmUserGroupRespVO;
import top.metass.pro.module.bpm.controller.admin.definition.vo.group.BpmUserGroupUpdateReqVO;
import top.metass.pro.module.bpm.dal.dataobject.definition.BpmUserGroupDO;
import top.metass.pro.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * 用户组 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface BpmUserGroupConvert {

    BpmUserGroupConvert INSTANCE = Mappers.getMapper(BpmUserGroupConvert.class);

    BpmUserGroupDO convert(BpmUserGroupCreateReqVO bean);

    BpmUserGroupDO convert(BpmUserGroupUpdateReqVO bean);

    BpmUserGroupRespVO convert(BpmUserGroupDO bean);

    List<BpmUserGroupRespVO> convertList(List<BpmUserGroupDO> list);

    PageResult<BpmUserGroupRespVO> convertPage(PageResult<BpmUserGroupDO> page);

    @Named("convertList2")
    List<BpmUserGroupRespVO> convertList2(List<BpmUserGroupDO> list);

}
