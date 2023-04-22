package top.metass.pro.module.product.controller.admin.sku;

import cn.hutool.core.collection.CollUtil;
import top.metass.pro.framework.common.pojo.CommonResult;
import top.metass.pro.framework.common.util.collection.MapUtils;
import top.metass.pro.module.product.controller.admin.sku.vo.ProductSkuOptionRespVO;
import top.metass.pro.module.product.convert.sku.ProductSkuConvert;
import top.metass.pro.module.product.dal.dataobject.sku.ProductSkuDO;
import top.metass.pro.module.product.dal.dataobject.spu.ProductSpuDO;
import top.metass.pro.module.product.service.sku.ProductSkuService;
import top.metass.pro.module.product.service.spu.ProductSpuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static top.metass.pro.framework.common.pojo.CommonResult.success;
import static top.metass.pro.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "管理后台 - 商品 sku")
@RestController
@RequestMapping("/product/sku")
@Validated
public class ProductSkuController {

    @Resource
    private ProductSkuService productSkuService;
    @Resource
    private ProductSpuService productSpuService;

    @GetMapping("/get-option-list")
    @Operation(summary = "获得商品 SKU 选项的列表")
//    @PreAuthorize("@ss.hasPermission('product:sku:query')")
    public CommonResult<List<ProductSkuOptionRespVO>> getSkuOptionList() {
        // 获得 SKU 列表
        List<ProductSkuDO> skus = productSkuService.getSkuList();
        if (CollUtil.isEmpty(skus)) {
            return success(Collections.emptyList());
        }

        // 获得对应的 SPU 映射
        Map<Long, ProductSpuDO> spuMap = productSpuService.getSpuMap(convertSet(skus, ProductSkuDO::getSpuId));
        // 转换为返回结果
        List<ProductSkuOptionRespVO> skuVOs = ProductSkuConvert.INSTANCE.convertList05(skus);
        skuVOs.forEach(sku -> MapUtils.findAndThen(spuMap, sku.getSpuId(),
                spu -> sku.setSpuId(spu.getId()).setSpuName(spu.getName())));
        return success(skuVOs);
    }

}
