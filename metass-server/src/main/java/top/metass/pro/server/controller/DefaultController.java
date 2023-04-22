package top.metass.pro.server.controller;

import top.metass.pro.framework.common.pojo.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static top.metass.pro.framework.common.exception.enums.GlobalErrorCodeConstants.NOT_IMPLEMENTED;

/**
 * 默认 Controller，解决部分 module 未开启时的 404 提示。
 * 例如说，/bpm/** 路径，工作流
 *
 * @author 三生宇宙
 */
@RestController
public class DefaultController {

    @RequestMapping("/admin-api/bpm/**")
    public CommonResult<Boolean> bpm404() {
        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
                "[工作流模块 metass-module-bpm - 已禁用][参考 https://doc.iocoder.cn/bpm/ 开启]");
    }

//    @RequestMapping("/admin-api/mp/**")
//    public CommonResult<Boolean> mp404() {
//        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
//                "[微信公众号 metass-module-mp - 已禁用][参考 https://doc.iocoder.cn/mp/build/ 开启]");
//    }

    @RequestMapping(value = {"/admin-api/product/**", // 商品中心
            "/admin-api/trade/**", // 交易中心
            "/admin-api/promotion/**"})  // 营销中心
    public CommonResult<Boolean> mall404() {
        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
                "[商城系统 metass-module-mall - 已禁用][参考 https://doc.iocoder.cn/mall/build/ 开启]");
    }

//    @RequestMapping(value = {"/admin-api/report/**"})
//    public CommonResult<Boolean> report404() {
//        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
//                "[报表模块 metass-module-report - 已禁用][参考 https://doc.iocoder.cn/report/ 开启]");
//    }

}
