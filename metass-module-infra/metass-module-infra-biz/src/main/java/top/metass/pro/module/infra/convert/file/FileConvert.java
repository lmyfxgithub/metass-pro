package top.metass.pro.module.infra.convert.file;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.infra.controller.admin.file.vo.file.FileRespVO;
import top.metass.pro.module.infra.dal.dataobject.file.FileDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileConvert {

    FileConvert INSTANCE = Mappers.getMapper(FileConvert.class);

    FileRespVO convert(FileDO bean);

    PageResult<FileRespVO> convertPage(PageResult<FileDO> page);

}
