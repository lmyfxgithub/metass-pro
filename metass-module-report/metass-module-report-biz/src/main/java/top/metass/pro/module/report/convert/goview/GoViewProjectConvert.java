package top.metass.pro.module.report.convert.goview;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.report.controller.admin.goview.vo.project.GoViewProjectCreateReqVO;
import top.metass.pro.module.report.controller.admin.goview.vo.project.GoViewProjectRespVO;
import top.metass.pro.module.report.controller.admin.goview.vo.project.GoViewProjectUpdateReqVO;
import top.metass.pro.module.report.dal.dataobject.goview.GoViewProjectDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoViewProjectConvert {

    GoViewProjectConvert INSTANCE = Mappers.getMapper(GoViewProjectConvert.class);

    GoViewProjectDO convert(GoViewProjectCreateReqVO bean);

    GoViewProjectDO convert(GoViewProjectUpdateReqVO bean);

    GoViewProjectRespVO convert(GoViewProjectDO bean);

    PageResult<GoViewProjectRespVO> convertPage(PageResult<GoViewProjectDO> page);

}
