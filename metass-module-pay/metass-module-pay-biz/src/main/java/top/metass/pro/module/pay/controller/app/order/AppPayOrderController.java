package top.metass.pro.module.pay.controller.app.order;

import top.metass.pro.framework.common.pojo.CommonResult;
import top.metass.pro.module.pay.api.order.dto.PayOrderCreateReqDTO;
import top.metass.pro.module.pay.controller.admin.demo.vo.PayDemoOrderCreateReqVO;
import top.metass.pro.module.pay.controller.admin.order.vo.PayOrderSubmitRespVO;
import top.metass.pro.module.pay.controller.app.order.vo.AppPayOrderCreateReqVO;
import top.metass.pro.module.pay.controller.app.order.vo.AppPayOrderQueryReqVO;
import top.metass.pro.module.pay.controller.app.order.vo.AppPayOrderSubmitReqVO;
import top.metass.pro.module.pay.controller.app.order.vo.AppPayOrderSubmitRespVO;
import top.metass.pro.module.pay.convert.order.PayOrderConvert;
import top.metass.pro.module.pay.dal.dataobject.order.PayOrderDO;
import top.metass.pro.module.pay.service.order.PayOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.time.Duration;

import static top.metass.pro.framework.common.pojo.CommonResult.success;
import static top.metass.pro.framework.common.util.date.LocalDateTimeUtils.addTime;
import static top.metass.pro.framework.common.util.servlet.ServletUtils.getClientIP;
import static top.metass.pro.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "用户 APP - 支付订单")
@RestController
@RequestMapping("/pay/order")
@Validated
@Slf4j
public class AppPayOrderController {

    @Resource
    private PayOrderService orderService;

    @PostMapping("/submit")
    @Operation(summary = "提交支付订单")
    public CommonResult<AppPayOrderSubmitRespVO> submitPayOrder(@RequestBody AppPayOrderSubmitReqVO reqVO) {
        PayOrderSubmitRespVO respVO = orderService.submitPayOrder(reqVO, getClientIP());
        return success(PayOrderConvert.INSTANCE.convert3(respVO));
    }

    @PostMapping("/create")
    @Operation(summary = "创建订单")
    public CommonResult<Long> createOrderBySpuId(@Valid @RequestBody AppPayOrderCreateReqVO createReqVO) {
        return success(orderService.createPayOrderBySpuId(createReqVO,getClientIP()));
    }

    @PostMapping("/queryOrderInfo")
    @Operation(summary = "查询支付订单")
    public CommonResult<PayOrderDO> queryOrderInfo(@RequestBody AppPayOrderQueryReqVO payOrderQueryReqVO) {
        return success(orderService.getOrder(payOrderQueryReqVO.getOrderId()));
    }

}
