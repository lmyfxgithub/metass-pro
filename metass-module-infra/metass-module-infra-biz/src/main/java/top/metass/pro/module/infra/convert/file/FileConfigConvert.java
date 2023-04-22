package top.metass.pro.module.infra.convert.file;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.infra.controller.admin.file.vo.config.FileConfigCreateReqVO;
import top.metass.pro.module.infra.controller.admin.file.vo.config.FileConfigRespVO;
import top.metass.pro.module.infra.controller.admin.file.vo.config.FileConfigUpdateReqVO;
import top.metass.pro.module.infra.dal.dataobject.file.FileConfigDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 文件配置 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface FileConfigConvert {

    FileConfigConvert INSTANCE = Mappers.getMapper(FileConfigConvert.class);

    @Mapping(target = "config", ignore = true)
    FileConfigDO convert(FileConfigCreateReqVO bean);

    @Mapping(target = "config", ignore = true)
    FileConfigDO convert(FileConfigUpdateReqVO bean);

    FileConfigRespVO convert(FileConfigDO bean);

    List<FileConfigRespVO> convertList(List<FileConfigDO> list);

    PageResult<FileConfigRespVO> convertPage(PageResult<FileConfigDO> page);

}
