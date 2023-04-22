package top.metass.pro.module.pay.dal.mysql.refund;

import top.metass.pro.module.pay.controller.admin.refund.vo.PayRefundExportReqVO;
import top.metass.pro.module.pay.controller.admin.refund.vo.PayRefundPageReqVO;
import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.mybatis.core.mapper.BaseMapperX;
import top.metass.pro.framework.mybatis.core.query.QueryWrapperX;
import top.metass.pro.module.pay.dal.dataobject.refund.PayRefundDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayRefundMapper extends BaseMapperX<PayRefundDO> {

    default PageResult<PayRefundDO> selectPage(PayRefundPageReqVO reqVO) {
        return selectPage(reqVO, new QueryWrapperX<PayRefundDO>()
                .eqIfPresent("merchant_id", reqVO.getMerchantId())
                .eqIfPresent("app_id", reqVO.getAppId())
                .eqIfPresent("channel_code", reqVO.getChannelCode())
                .likeIfPresent("merchant_refund_no", reqVO.getMerchantRefundNo())
                .eqIfPresent("type", reqVO.getType())
                .eqIfPresent("status", reqVO.getStatus())
                .eqIfPresent("notify_status", reqVO.getNotifyStatus())
                .betweenIfPresent("create_time", reqVO.getCreateTime())
                .orderByDesc("id"));
    }

    default List<PayRefundDO> selectList(PayRefundExportReqVO reqVO) {
        return selectList(new QueryWrapperX<PayRefundDO>()
                .eqIfPresent("merchant_id", reqVO.getMerchantId())
                .eqIfPresent("app_id", reqVO.getAppId())
                .eqIfPresent("channel_code", reqVO.getChannelCode())
                .likeIfPresent("merchant_refund_no", reqVO.getMerchantRefundNo())
                .eqIfPresent("type", reqVO.getType())
                .eqIfPresent("status", reqVO.getStatus())
                .eqIfPresent("notify_status", reqVO.getNotifyStatus())
                .betweenIfPresent("create_time", reqVO.getCreateTime())
                .orderByDesc("id"));
    }

    default Long selectCount(Long appId, Integer status) {

        return selectCount(new LambdaQueryWrapper<PayRefundDO>()
                .eq(PayRefundDO::getAppId, appId)
                .eq(PayRefundDO::getStatus, status));
    }

    default PayRefundDO selectByReqNo(String reqNo) {
        return selectOne("req_no", reqNo);
    }

    default  PayRefundDO selectByTradeNoAndMerchantRefundNo(String tradeNo, String merchantRefundNo){
        return selectOne("trade_no", tradeNo, "merchant_refund_no", merchantRefundNo);
    }
}
