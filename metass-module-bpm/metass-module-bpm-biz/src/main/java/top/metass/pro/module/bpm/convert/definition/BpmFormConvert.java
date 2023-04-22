package top.metass.pro.module.bpm.convert.definition;

import top.metass.pro.module.bpm.controller.admin.definition.vo.form.BpmFormCreateReqVO;
import top.metass.pro.module.bpm.controller.admin.definition.vo.form.BpmFormRespVO;
import top.metass.pro.module.bpm.controller.admin.definition.vo.form.BpmFormSimpleRespVO;
import top.metass.pro.module.bpm.controller.admin.definition.vo.form.BpmFormUpdateReqVO;
import top.metass.pro.module.bpm.dal.dataobject.definition.BpmFormDO;
import top.metass.pro.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 动态表单 Convert
 *
 * @author 三生
 */
@Mapper
public interface BpmFormConvert {

    BpmFormConvert INSTANCE = Mappers.getMapper(BpmFormConvert.class);

    BpmFormDO convert(BpmFormCreateReqVO bean);

    BpmFormDO convert(BpmFormUpdateReqVO bean);

    BpmFormRespVO convert(BpmFormDO bean);

    List<BpmFormSimpleRespVO> convertList2(List<BpmFormDO> list);

    PageResult<BpmFormRespVO> convertPage(PageResult<BpmFormDO> page);

}
