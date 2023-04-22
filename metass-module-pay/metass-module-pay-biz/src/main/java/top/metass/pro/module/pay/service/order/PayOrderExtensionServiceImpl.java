package top.metass.pro.module.pay.service.order;

import top.metass.pro.module.pay.dal.dataobject.order.PayOrderExtensionDO;
import top.metass.pro.module.pay.dal.mysql.order.PayOrderExtensionMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 支付订单 Service 实现类
 *
 * @author aquan
 */
@Service
@Validated
public class PayOrderExtensionServiceImpl implements PayOrderExtensionService {

    @Resource
    private PayOrderExtensionMapper orderExtensionMapper;

    @Override
    public PayOrderExtensionDO getOrderExtension(Long id) {
        return orderExtensionMapper.selectById(id);
    }

    @Override
    public PayOrderExtensionDO getOrderExtensionByOrderNo(String channelOrderNo) {
        return orderExtensionMapper.selectByNo(channelOrderNo);
    }

    @Override
    public List<PayOrderExtensionDO> getOrderExtensionList(Collection<Long> ids) {
        return orderExtensionMapper.selectBatchIds(ids);
    }

}
