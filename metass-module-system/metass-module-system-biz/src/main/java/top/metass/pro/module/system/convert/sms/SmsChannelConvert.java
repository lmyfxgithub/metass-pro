package top.metass.pro.module.system.convert.sms;

import top.metass.pro.module.system.controller.admin.sms.vo.channel.SmsChannelCreateReqVO;
import top.metass.pro.module.system.controller.admin.sms.vo.channel.SmsChannelRespVO;
import top.metass.pro.module.system.controller.admin.sms.vo.channel.SmsChannelSimpleRespVO;
import top.metass.pro.module.system.controller.admin.sms.vo.channel.SmsChannelUpdateReqVO;
import top.metass.pro.module.system.dal.dataobject.sms.SmsChannelDO;
import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.sms.core.property.SmsChannelProperties;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 短信渠道 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface SmsChannelConvert {

    SmsChannelConvert INSTANCE = Mappers.getMapper(SmsChannelConvert.class);

    SmsChannelDO convert(SmsChannelCreateReqVO bean);

    SmsChannelDO convert(SmsChannelUpdateReqVO bean);

    SmsChannelRespVO convert(SmsChannelDO bean);

    List<SmsChannelRespVO> convertList(List<SmsChannelDO> list);

    PageResult<SmsChannelRespVO> convertPage(PageResult<SmsChannelDO> page);

    List<SmsChannelProperties> convertList02(List<SmsChannelDO> list);

    List<SmsChannelSimpleRespVO> convertList03(List<SmsChannelDO> list);

}
