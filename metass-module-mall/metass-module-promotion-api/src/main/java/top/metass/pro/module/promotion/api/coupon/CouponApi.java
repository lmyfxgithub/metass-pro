package top.metass.pro.module.promotion.api.coupon;

import top.metass.pro.module.promotion.api.coupon.dto.CouponUseReqDTO;

import javax.validation.Valid;

/**
 * 优惠劵 API 接口
 *
 * @author 三生宇宙
 */
public interface CouponApi {

    /**
     * 使用优惠劵
     *
     * @param useReqDTO 使用请求
     */
    void useCoupon(@Valid CouponUseReqDTO useReqDTO);

}
