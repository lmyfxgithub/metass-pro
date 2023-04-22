package top.metass.pro.module.promotion.convert.coupon;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.promotion.controller.admin.coupon.vo.template.CouponTemplateCreateReqVO;
import top.metass.pro.module.promotion.controller.admin.coupon.vo.template.CouponTemplateRespVO;
import top.metass.pro.module.promotion.controller.admin.coupon.vo.template.CouponTemplateUpdateReqVO;
import top.metass.pro.module.promotion.dal.dataobject.coupon.CouponTemplateDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 优惠劵模板 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface CouponTemplateConvert {

    CouponTemplateConvert INSTANCE = Mappers.getMapper(CouponTemplateConvert.class);

    CouponTemplateDO convert(CouponTemplateCreateReqVO bean);

    CouponTemplateDO convert(CouponTemplateUpdateReqVO bean);

    CouponTemplateRespVO convert(CouponTemplateDO bean);

    PageResult<CouponTemplateRespVO> convertPage(PageResult<CouponTemplateDO> page);

}
