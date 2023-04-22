package top.metass.pro.module.promotion.convert.coupon;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.promotion.controller.admin.coupon.vo.coupon.CouponPageItemRespVO;
import top.metass.pro.module.promotion.dal.dataobject.coupon.CouponDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 优惠劵 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface CouponConvert {

    CouponConvert INSTANCE = Mappers.getMapper(CouponConvert.class);

    PageResult<CouponPageItemRespVO> convertPage(PageResult<CouponDO> page);

}
