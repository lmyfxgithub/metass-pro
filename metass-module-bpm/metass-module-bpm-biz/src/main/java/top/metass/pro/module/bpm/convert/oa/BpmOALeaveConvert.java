package top.metass.pro.module.bpm.convert.oa;

import top.metass.pro.module.bpm.controller.admin.oa.vo.BpmOALeaveCreateReqVO;
import top.metass.pro.module.bpm.controller.admin.oa.vo.BpmOALeaveRespVO;
import top.metass.pro.module.bpm.dal.dataobject.oa.BpmOALeaveDO;
import top.metass.pro.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 请假申请 Convert
 *
 * @author 三生
 */
@Mapper
public interface BpmOALeaveConvert {

    BpmOALeaveConvert INSTANCE = Mappers.getMapper(BpmOALeaveConvert.class);

    BpmOALeaveDO convert(BpmOALeaveCreateReqVO bean);

    BpmOALeaveRespVO convert(BpmOALeaveDO bean);

    List<BpmOALeaveRespVO> convertList(List<BpmOALeaveDO> list);

    PageResult<BpmOALeaveRespVO> convertPage(PageResult<BpmOALeaveDO> page);

}
