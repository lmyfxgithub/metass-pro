package top.metass.pro.module.trade.dal.mysql.aftersale;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.mybatis.core.mapper.BaseMapperX;
import top.metass.pro.framework.mybatis.core.query.LambdaQueryWrapperX;
import top.metass.pro.module.trade.controller.admin.aftersale.vo.TradeAfterSalePageReqVO;
import top.metass.pro.module.trade.dal.dataobject.aftersale.TradeAfterSaleDO;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TradeAfterSaleMapper extends BaseMapperX<TradeAfterSaleDO> {

    default PageResult<TradeAfterSaleDO> selectPage(TradeAfterSalePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TradeAfterSaleDO>()
                .likeIfPresent(TradeAfterSaleDO::getNo, reqVO.getNo())
                .eqIfPresent(TradeAfterSaleDO::getStatus, reqVO.getStatus())
                .eqIfPresent(TradeAfterSaleDO::getType, reqVO.getType())
                .eqIfPresent(TradeAfterSaleDO::getWay, reqVO.getWay())
                .likeIfPresent(TradeAfterSaleDO::getOrderNo, reqVO.getOrderNo())
                .likeIfPresent(TradeAfterSaleDO::getSpuName, reqVO.getSpuName())
                .betweenIfPresent(TradeAfterSaleDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TradeAfterSaleDO::getId));
    }

    default int updateByIdAndStatus(Long id, Integer status, TradeAfterSaleDO update) {
        return update(update, new LambdaUpdateWrapper<TradeAfterSaleDO>()
                .eq(TradeAfterSaleDO::getId, id).eq(TradeAfterSaleDO::getStatus, status));
    }

    default TradeAfterSaleDO selectByPayRefundId(Long payRefundId) {
        return selectOne(TradeAfterSaleDO::getPayRefundId, payRefundId);
    }

}
