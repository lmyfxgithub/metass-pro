package top.metass.pro.module.system.convert.dept;

import top.metass.pro.module.system.api.dept.dto.DeptRespDTO;
import top.metass.pro.module.system.controller.admin.dept.vo.dept.DeptCreateReqVO;
import top.metass.pro.module.system.controller.admin.dept.vo.dept.DeptRespVO;
import top.metass.pro.module.system.controller.admin.dept.vo.dept.DeptSimpleRespVO;
import top.metass.pro.module.system.controller.admin.dept.vo.dept.DeptUpdateReqVO;
import top.metass.pro.module.system.dal.dataobject.dept.DeptDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeptConvert {

    DeptConvert INSTANCE = Mappers.getMapper(DeptConvert.class);

    List<DeptRespVO> convertList(List<DeptDO> list);

    List<DeptSimpleRespVO> convertList02(List<DeptDO> list);

    DeptRespVO convert(DeptDO bean);

    DeptDO convert(DeptCreateReqVO bean);

    DeptDO convert(DeptUpdateReqVO bean);

    List<DeptRespDTO> convertList03(List<DeptDO> list);

    DeptRespDTO convert03(DeptDO bean);

}
