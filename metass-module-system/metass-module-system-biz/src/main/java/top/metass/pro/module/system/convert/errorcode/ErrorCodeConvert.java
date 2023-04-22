package top.metass.pro.module.system.convert.errorcode;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.system.api.errorcode.dto.ErrorCodeAutoGenerateReqDTO;
import top.metass.pro.module.system.api.errorcode.dto.ErrorCodeRespDTO;
import top.metass.pro.module.system.controller.admin.errorcode.vo.ErrorCodeCreateReqVO;
import top.metass.pro.module.system.controller.admin.errorcode.vo.ErrorCodeExcelVO;
import top.metass.pro.module.system.controller.admin.errorcode.vo.ErrorCodeRespVO;
import top.metass.pro.module.system.controller.admin.errorcode.vo.ErrorCodeUpdateReqVO;
import top.metass.pro.module.system.dal.dataobject.errorcode.ErrorCodeDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 错误码 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface ErrorCodeConvert {

    ErrorCodeConvert INSTANCE = Mappers.getMapper(ErrorCodeConvert.class);

    ErrorCodeDO convert(ErrorCodeCreateReqVO bean);

    ErrorCodeDO convert(ErrorCodeUpdateReqVO bean);

    ErrorCodeRespVO convert(ErrorCodeDO bean);

    List<ErrorCodeRespVO> convertList(List<ErrorCodeDO> list);

    PageResult<ErrorCodeRespVO> convertPage(PageResult<ErrorCodeDO> page);

    List<ErrorCodeExcelVO> convertList02(List<ErrorCodeDO> list);

    ErrorCodeDO convert(ErrorCodeAutoGenerateReqDTO bean);

    List<ErrorCodeRespDTO> convertList03(List<ErrorCodeDO> list);

}
