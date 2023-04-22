package top.metass.pro.module.system.convert.notice;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.system.controller.admin.notice.vo.NoticeCreateReqVO;
import top.metass.pro.module.system.controller.admin.notice.vo.NoticeRespVO;
import top.metass.pro.module.system.controller.admin.notice.vo.NoticeUpdateReqVO;
import top.metass.pro.module.system.dal.dataobject.notice.NoticeDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoticeConvert {

    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    PageResult<NoticeRespVO> convertPage(PageResult<NoticeDO> page);

    NoticeRespVO convert(NoticeDO bean);

    NoticeDO convert(NoticeUpdateReqVO bean);

    NoticeDO convert(NoticeCreateReqVO bean);

}
