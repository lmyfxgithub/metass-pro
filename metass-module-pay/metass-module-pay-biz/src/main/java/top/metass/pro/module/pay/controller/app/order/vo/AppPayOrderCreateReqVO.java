package top.metass.pro.module.pay.controller.app.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * @author jiangdi
 * @version 2023/4/12 14:19 top.metass.pro.module.pay.controller.app.order.vo.AppPayOrderCreateReqVO.java V1.0
 */
@Schema(description = "用户 APP - 创建支付订单 Request VO")
@Data
public class AppPayOrderCreateReqVO {


    /**
     * 商品编号
     */
    @NotNull(message = "商品编号")
    private Long spuId;

    /**
     * 商户订单编号
     */
    @NotEmpty(message = "商户订单编号不能为空")
    private String merchantOrderId;

    /**
     * 应用编号
     */
    @NotNull(message = "应用编号不能为空")
    private Long appId;
}
