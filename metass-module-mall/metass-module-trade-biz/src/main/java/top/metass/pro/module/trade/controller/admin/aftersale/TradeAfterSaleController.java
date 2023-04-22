package top.metass.pro.module.trade.controller.admin.aftersale;

import cn.hutool.core.collection.CollUtil;
import top.metass.pro.framework.common.pojo.CommonResult;
import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.member.api.user.MemberUserApi;
import top.metass.pro.module.member.api.user.dto.MemberUserRespDTO;
import top.metass.pro.module.product.api.property.ProductPropertyValueApi;
import top.metass.pro.module.product.api.property.dto.ProductPropertyValueDetailRespDTO;
import top.metass.pro.module.trade.controller.admin.aftersale.vo.TradeAfterSaleDisagreeReqVO;
import top.metass.pro.module.trade.controller.admin.aftersale.vo.TradeAfterSalePageReqVO;
import top.metass.pro.module.trade.controller.admin.aftersale.vo.TradeAfterSaleRefuseReqVO;
import top.metass.pro.module.trade.controller.admin.aftersale.vo.TradeAfterSaleRespPageItemVO;
import top.metass.pro.module.trade.convert.aftersale.TradeAfterSaleConvert;
import top.metass.pro.module.trade.dal.dataobject.aftersale.TradeAfterSaleDO;
import top.metass.pro.module.trade.service.aftersale.TradeAfterSaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static top.metass.pro.framework.common.pojo.CommonResult.success;
import static top.metass.pro.framework.common.util.collection.CollectionUtils.convertSet;
import static top.metass.pro.framework.common.util.servlet.ServletUtils.getClientIP;
import static top.metass.pro.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "管理后台 - 交易售后")
@RestController
@RequestMapping("/trade/after-sale")
@Validated
@Slf4j
public class TradeAfterSaleController {

    @Resource
    private TradeAfterSaleService afterSaleService;

    @Resource
    private MemberUserApi memberUserApi;
    @Resource
    private ProductPropertyValueApi productPropertyValueApi;

    @GetMapping("/page")
    @Operation(summary = "获得交易售后分页")
    @PreAuthorize("@ss.hasPermission('trade:after-sale:query')")
    public CommonResult<PageResult<TradeAfterSaleRespPageItemVO>> getAfterSalePage(@Valid TradeAfterSalePageReqVO pageVO) {
        // 查询售后
        PageResult<TradeAfterSaleDO> pageResult = afterSaleService.getAfterSalePage(pageVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty());
        }

        // 查询商品属性
        List<ProductPropertyValueDetailRespDTO> propertyValueDetails = productPropertyValueApi
                .getPropertyValueDetailList(TradeAfterSaleConvert.INSTANCE.convertPropertyValueIds(pageResult.getList()));
        // 查询会员
        Map<Long, MemberUserRespDTO> memberUsers = memberUserApi.getUserMap(
                convertSet(pageResult.getList(), TradeAfterSaleDO::getUserId));
        return success(TradeAfterSaleConvert.INSTANCE.convertPage(pageResult, memberUsers, propertyValueDetails));
    }

    @PutMapping("/agree")
    @Operation(summary = "同意售后")
    @Parameter(name = "id", description = "售后编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('trade:after-sale:agree')")
    public CommonResult<Boolean> agreeAfterSale(@RequestParam("id") Long id) {
        afterSaleService.agreeAfterSale(getLoginUserId(), id);
        return success(true);
    }

    @PutMapping("/disagree")
    @Operation(summary = "拒绝售后")
    @PreAuthorize("@ss.hasPermission('trade:after-sale:disagree')")
    public CommonResult<Boolean> disagreeAfterSale(@RequestBody TradeAfterSaleDisagreeReqVO confirmReqVO) {
        afterSaleService.disagreeAfterSale(getLoginUserId(), confirmReqVO);
        return success(true);
    }

    @PutMapping("/receive")
    @Operation(summary = "确认收货")
    @Parameter(name = "id", description = "售后编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('trade:after-sale:receive')")
    public CommonResult<Boolean> receiveAfterSale(@RequestParam("id") Long id) {
        afterSaleService.receiveAfterSale(getLoginUserId(), id);
        return success(true);
    }

    @PutMapping("/refuse")
    @Operation(summary = "确认收货")
    @Parameter(name = "id", description = "售后编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('trade:after-sale:receive')")
    public CommonResult<Boolean> refuseAfterSale(TradeAfterSaleRefuseReqVO refuseReqVO) {
        afterSaleService.refuseAfterSale(getLoginUserId(), refuseReqVO);
        return success(true);
    }

    @PostMapping("/refund")
    @Operation(summary = "确认退款")
    @Parameter(name = "id", description = "售后编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('trade:after-sale:refund')")
    public CommonResult<Boolean> refundAfterSale(@RequestParam("id") Long id) {
        afterSaleService.refundAfterSale(getLoginUserId(), getClientIP(), id);
        return success(true);
    }

}
