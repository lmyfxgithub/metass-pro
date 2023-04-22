package top.metass.pro.module.promotion.api.price;

import top.metass.pro.module.promotion.api.price.dto.PriceCalculateReqDTO;
import top.metass.pro.module.promotion.api.price.dto.PriceCalculateRespDTO;
import top.metass.pro.module.promotion.service.price.PriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 价格 API 实现类
 *
 * @author 三生宇宙
 */
@Service
public class PriceApiImpl implements PriceApi {

    @Resource
    private PriceService priceService;

    @Override
    public PriceCalculateRespDTO calculatePrice(PriceCalculateReqDTO calculateReqDTO) {
        return priceService.calculatePrice(calculateReqDTO);
    }

}
