package top.metass.pro.module.promotion.controller.admin.coupon.vo.template;

import top.metass.pro.framework.common.enums.CommonStatusEnum;
import top.metass.pro.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 优惠劵模板更新状态 Request VO")
@Data
public class CouponTemplateUpdateStatusReqVO {

    @Schema(description = "优惠劵模板编号", required = true, example = "1024")
    @NotNull(message = "优惠劵模板编号不能为空")
    private Long id;

    @Schema(description = "状态", required = true, example = "1")
    @NotNull(message = "状态不能为空")
    @InEnum(value = CommonStatusEnum.class, message = "修改状态必须是 {value}")
    private Integer status;

}
