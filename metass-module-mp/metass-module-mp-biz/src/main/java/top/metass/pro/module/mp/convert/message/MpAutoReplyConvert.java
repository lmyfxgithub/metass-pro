package top.metass.pro.module.mp.convert.message;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.mp.controller.admin.message.vo.autoreply.MpAutoReplyCreateReqVO;
import top.metass.pro.module.mp.controller.admin.message.vo.autoreply.MpAutoReplyRespVO;
import top.metass.pro.module.mp.controller.admin.message.vo.autoreply.MpAutoReplyUpdateReqVO;
import top.metass.pro.module.mp.dal.dataobject.message.MpAutoReplyDO;
import top.metass.pro.module.mp.service.message.bo.MpMessageSendOutReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MpAutoReplyConvert {

    MpAutoReplyConvert INSTANCE = Mappers.getMapper(MpAutoReplyConvert.class);

    @Mappings({
            @Mapping(source = "reply.appId", target = "appId"),
            @Mapping(source = "reply.responseMessageType", target = "type"),
            @Mapping(source = "reply.responseContent", target = "content"),
            @Mapping(source = "reply.responseMediaId", target = "mediaId"),
            @Mapping(source = "reply.responseTitle", target = "title"),
            @Mapping(source = "reply.responseDescription", target = "description"),
            @Mapping(source = "reply.responseArticles", target = "articles"),
    })
    MpMessageSendOutReqBO convert(String openid, MpAutoReplyDO reply);

    PageResult<MpAutoReplyRespVO> convertPage(PageResult<MpAutoReplyDO> page);

    MpAutoReplyRespVO convert(MpAutoReplyDO bean);

    MpAutoReplyDO convert(MpAutoReplyCreateReqVO bean);

    MpAutoReplyDO convert(MpAutoReplyUpdateReqVO bean);
}
