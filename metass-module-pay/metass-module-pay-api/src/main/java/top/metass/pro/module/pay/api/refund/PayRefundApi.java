package top.metass.pro.module.pay.api.refund;

import top.metass.pro.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import top.metass.pro.module.pay.api.refund.dto.PayRefundRespDTO;

import javax.validation.Valid;

/**
 * 退款单 API 接口
 *
 * @author 三生宇宙
 */
public interface PayRefundApi {

    /**
     * 创建退款单
     *
     * @param reqDTO 创建请求
     * @return 退款单编号
     */
    Long createPayRefund(@Valid PayRefundCreateReqDTO reqDTO);

    /**
     * 获得退款单
     *
     * @param id 退款单编号
     * @return 退款单
     */
    PayRefundRespDTO getPayRefund(Long id);

}
