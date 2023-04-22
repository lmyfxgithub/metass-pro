package top.metass.pro.module.system.convert.logger;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.system.api.logger.dto.LoginLogCreateReqDTO;
import top.metass.pro.module.system.controller.admin.logger.vo.loginlog.LoginLogExcelVO;
import top.metass.pro.module.system.controller.admin.logger.vo.loginlog.LoginLogRespVO;
import top.metass.pro.module.system.dal.dataobject.logger.LoginLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LoginLogConvert {

    LoginLogConvert INSTANCE = Mappers.getMapper(LoginLogConvert.class);

    PageResult<LoginLogRespVO> convertPage(PageResult<LoginLogDO> page);

    List<LoginLogExcelVO> convertList(List<LoginLogDO> list);

    LoginLogDO convert(LoginLogCreateReqDTO bean);

}
