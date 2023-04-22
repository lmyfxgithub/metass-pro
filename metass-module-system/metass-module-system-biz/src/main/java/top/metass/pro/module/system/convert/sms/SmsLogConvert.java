package top.metass.pro.module.system.convert.sms;

import top.metass.pro.module.system.controller.admin.sms.vo.log.SmsLogExcelVO;
import top.metass.pro.module.system.controller.admin.sms.vo.log.SmsLogRespVO;
import top.metass.pro.module.system.dal.dataobject.sms.SmsLogDO;
import top.metass.pro.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 短信日志 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface SmsLogConvert {

    SmsLogConvert INSTANCE = Mappers.getMapper(SmsLogConvert.class);

    SmsLogRespVO convert(SmsLogDO bean);

    List<SmsLogRespVO> convertList(List<SmsLogDO> list);

    PageResult<SmsLogRespVO> convertPage(PageResult<SmsLogDO> page);

    List<SmsLogExcelVO> convertList02(List<SmsLogDO> list);

}
