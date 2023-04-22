package top.metass.pro.module.member.dal.mysql.spu;

import java.util.*;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.mybatis.core.query.LambdaQueryWrapperX;
import top.metass.pro.framework.mybatis.core.mapper.BaseMapperX;
import top.metass.pro.module.member.dal.dataobject.spu.SpuDO;
import org.apache.ibatis.annotations.Mapper;
import top.metass.pro.module.member.controller.admin.spu.vo.*;

/**
 * 会员商品 Mapper
 *
 * @author 三生
 */
@Mapper
public interface SpuMapper extends BaseMapperX<SpuDO> {

    default PageResult<SpuDO> selectPage(SpuPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SpuDO>()
                .likeIfPresent(SpuDO::getName, reqVO.getName())
                .eqIfPresent(SpuDO::getPrice, reqVO.getPrice())
                .eqIfPresent(SpuDO::getType, reqVO.getType())
                .eqIfPresent(SpuDO::getInfo, reqVO.getInfo())
                .eqIfPresent(SpuDO::getStatus, reqVO.getStatus())
                .eqIfPresent(SpuDO::getRemark, reqVO.getRemark())
                .orderByDesc(SpuDO::getId));
    }

    default List<SpuDO> selectList(SpuExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SpuDO>()
                .likeIfPresent(SpuDO::getName, reqVO.getName())
                .eqIfPresent(SpuDO::getPrice, reqVO.getPrice())
                .eqIfPresent(SpuDO::getType, reqVO.getType())
                .eqIfPresent(SpuDO::getInfo, reqVO.getInfo())
                .eqIfPresent(SpuDO::getStatus, reqVO.getStatus())
                .eqIfPresent(SpuDO::getRemark, reqVO.getRemark())
                .orderByDesc(SpuDO::getId));
    }

    default List<SpuDO> selectList(SpuDO spuDo) {
        return selectList(new LambdaQueryWrapperX<SpuDO>()
                .likeIfPresent(SpuDO::getName, spuDo.getName())
                .eqIfPresent(SpuDO::getType, spuDo.getType())
                .eqIfPresent(SpuDO::getInfo, spuDo.getInfo())
                .eqIfPresent(SpuDO::getStatus, spuDo.getStatus())
                .eqIfPresent(SpuDO::getRemark, spuDo.getRemark())
                .orderByDesc(SpuDO::getId));
    }

}
