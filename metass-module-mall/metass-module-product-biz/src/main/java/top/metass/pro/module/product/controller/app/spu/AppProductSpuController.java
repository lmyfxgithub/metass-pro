package top.metass.pro.module.product.controller.app.spu;

import top.metass.pro.framework.common.enums.CommonStatusEnum;
import top.metass.pro.framework.common.pojo.CommonResult;
import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.product.controller.app.spu.vo.AppProductSpuDetailRespVO;
import top.metass.pro.module.product.controller.app.spu.vo.AppProductSpuPageItemRespVO;
import top.metass.pro.module.product.controller.app.spu.vo.AppProductSpuPageReqVO;
import top.metass.pro.module.product.convert.sku.ProductSkuConvert;
import top.metass.pro.module.product.convert.spu.ProductSpuConvert;
import top.metass.pro.module.product.dal.dataobject.sku.ProductSkuDO;
import top.metass.pro.module.product.dal.dataobject.spu.ProductSpuDO;
import top.metass.pro.module.product.enums.spu.ProductSpuStatusEnum;
import top.metass.pro.module.product.service.property.ProductPropertyValueService;
import top.metass.pro.module.product.service.property.bo.ProductPropertyValueDetailRespBO;
import top.metass.pro.module.product.service.sku.ProductSkuService;
import top.metass.pro.module.product.service.spu.ProductSpuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static top.metass.pro.framework.common.exception.util.ServiceExceptionUtil.exception;
import static top.metass.pro.framework.common.pojo.CommonResult.success;
import static top.metass.pro.module.product.enums.ErrorCodeConstants.SPU_NOT_ENABLE;
import static top.metass.pro.module.product.enums.ErrorCodeConstants.SPU_NOT_EXISTS;

@Tag(name = "用户 APP - 商品 SPU")
@RestController
@RequestMapping("/product/spu")
@Validated
public class AppProductSpuController {

    @Resource
    private ProductSpuService productSpuService;
    @Resource
    private ProductSkuService productSkuService;
    @Resource
    private ProductPropertyValueService productPropertyValueService;

    @GetMapping("/page")
    @Operation(summary = "获得商品 SPU 分页")
    public CommonResult<PageResult<AppProductSpuPageItemRespVO>> getSpuPage(@Valid AppProductSpuPageReqVO pageVO) {
        PageResult<ProductSpuDO> pageResult = productSpuService.getSpuPage(pageVO, ProductSpuStatusEnum.ENABLE.getStatus());
        return success(ProductSpuConvert.INSTANCE.convertPage02(pageResult));
    }

    @GetMapping("/get-detail")
    @Operation(summary = "获得商品 SPU 明细")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<AppProductSpuDetailRespVO> getSpuDetail(@RequestParam("id") Long id) {
        // 获得商品 SPU
        ProductSpuDO spu = productSpuService.getSpu(id);
        if (spu == null) {
            throw exception(SPU_NOT_EXISTS);
        }
        if (!ProductSpuStatusEnum.isEnable(spu.getStatus())) {
            throw exception(SPU_NOT_ENABLE);
        }

        // 查询商品 SKU
        List<ProductSkuDO> skus = productSkuService.getSkuListBySpuIdAndStatus(spu.getId(),
                CommonStatusEnum.ENABLE.getStatus());
        // 查询商品属性
        List<ProductPropertyValueDetailRespBO> propertyValues = productPropertyValueService
                .getPropertyValueDetailList(ProductSkuConvert.INSTANCE.convertPropertyValueIds(skus));
        // 拼接
        return success(ProductSpuConvert.INSTANCE.convert(spu, skus, propertyValues));
    }

}
