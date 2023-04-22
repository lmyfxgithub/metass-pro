package top.metass.pro.module.infra.dal.mysql.test;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.mybatis.core.mapper.BaseMapperX;
import top.metass.pro.framework.mybatis.core.query.LambdaQueryWrapperX;
import top.metass.pro.module.infra.controller.admin.test.vo.TestDemoExportReqVO;
import top.metass.pro.module.infra.controller.admin.test.vo.TestDemoPageReqVO;
import top.metass.pro.module.infra.dal.dataobject.test.TestDemoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典类型 Mapper
 *
 * @author 三生宇宙
 */
@Mapper
public interface TestDemoMapper extends BaseMapperX<TestDemoDO> {

    default PageResult<TestDemoDO> selectPage(TestDemoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TestDemoDO>()
                .likeIfPresent(TestDemoDO::getName, reqVO.getName())
                .eqIfPresent(TestDemoDO::getStatus, reqVO.getStatus())
                .eqIfPresent(TestDemoDO::getType, reqVO.getType())
                .eqIfPresent(TestDemoDO::getCategory, reqVO.getCategory())
                .eqIfPresent(TestDemoDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(TestDemoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TestDemoDO::getId));
    }

    default List<TestDemoDO> selectList(TestDemoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<TestDemoDO>()
                .likeIfPresent(TestDemoDO::getName, reqVO.getName())
                .eqIfPresent(TestDemoDO::getStatus, reqVO.getStatus())
                .eqIfPresent(TestDemoDO::getType, reqVO.getType())
                .eqIfPresent(TestDemoDO::getCategory, reqVO.getCategory())
                .eqIfPresent(TestDemoDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(TestDemoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TestDemoDO::getId));
    }

    List<TestDemoDO> selectList2();

}
