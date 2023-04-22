package top.metass.pro.module.infra.convert.job;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.infra.controller.admin.job.vo.job.JobCreateReqVO;
import top.metass.pro.module.infra.controller.admin.job.vo.job.JobExcelVO;
import top.metass.pro.module.infra.controller.admin.job.vo.job.JobRespVO;
import top.metass.pro.module.infra.controller.admin.job.vo.job.JobUpdateReqVO;
import top.metass.pro.module.infra.dal.dataobject.job.JobDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 定时任务 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface JobConvert {

    JobConvert INSTANCE = Mappers.getMapper(JobConvert.class);

    JobDO convert(JobCreateReqVO bean);

    JobDO convert(JobUpdateReqVO bean);

    JobRespVO convert(JobDO bean);

    List<JobRespVO> convertList(List<JobDO> list);

    PageResult<JobRespVO> convertPage(PageResult<JobDO> page);

    List<JobExcelVO> convertList02(List<JobDO> list);

}
