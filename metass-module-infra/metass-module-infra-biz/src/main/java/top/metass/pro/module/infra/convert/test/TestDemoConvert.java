package top.metass.pro.module.infra.convert.test;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.infra.controller.admin.test.vo.TestDemoCreateReqVO;
import top.metass.pro.module.infra.controller.admin.test.vo.TestDemoExcelVO;
import top.metass.pro.module.infra.controller.admin.test.vo.TestDemoRespVO;
import top.metass.pro.module.infra.controller.admin.test.vo.TestDemoUpdateReqVO;
import top.metass.pro.module.infra.dal.dataobject.test.TestDemoDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 字典类型 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface TestDemoConvert {

    TestDemoConvert INSTANCE = Mappers.getMapper(TestDemoConvert.class);

    TestDemoDO convert(TestDemoCreateReqVO bean);

    TestDemoDO convert(TestDemoUpdateReqVO bean);

    TestDemoRespVO convert(TestDemoDO bean);

    List<TestDemoRespVO> convertList(List<TestDemoDO> list);

    PageResult<TestDemoRespVO> convertPage(PageResult<TestDemoDO> page);

    List<TestDemoExcelVO> convertList02(List<TestDemoDO> list);

}
