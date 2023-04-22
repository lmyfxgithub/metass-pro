package top.metass.pro.module.pay.api.refund;

import top.metass.pro.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import top.metass.pro.module.pay.api.refund.dto.PayRefundRespDTO;
import top.metass.pro.module.pay.service.refund.PayRefundService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 退款单 API 实现类
 *
 * @author 三生宇宙
 */
@Service
@Validated
public class PayRefundApiImpl implements PayRefundApi {

    @Resource
    private PayRefundService payRefundService;

    @Override
    public Long createPayRefund(PayRefundCreateReqDTO reqDTO) {
        return payRefundService.createPayRefund(reqDTO);
    }

    @Override
    public PayRefundRespDTO getPayRefund(Long id) {
        // TODO 三生：暂未实现
        return null;
    }

}
