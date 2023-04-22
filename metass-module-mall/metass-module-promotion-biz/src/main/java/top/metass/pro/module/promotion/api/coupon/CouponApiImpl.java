package top.metass.pro.module.promotion.api.coupon;


import top.metass.pro.module.promotion.api.coupon.dto.CouponUseReqDTO;
import top.metass.pro.module.promotion.service.coupon.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 优惠劵 API 实现类
 *
 * @author 三生宇宙
 */
@Service
public class CouponApiImpl implements CouponApi {

    @Resource
    private CouponService couponService;

    @Override
    public void useCoupon(CouponUseReqDTO useReqDTO) {
        couponService.useCoupon(useReqDTO.getId(), useReqDTO.getUserId(),
                useReqDTO.getOrderId());
    }

}
