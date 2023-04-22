package top.metass.pro.module.product.api.sku;

import cn.hutool.core.collection.CollUtil;
import top.metass.pro.module.product.api.sku.dto.ProductSkuRespDTO;
import top.metass.pro.module.product.api.sku.dto.ProductSkuUpdateStockReqDTO;
import top.metass.pro.module.product.convert.sku.ProductSkuConvert;
import top.metass.pro.module.product.dal.dataobject.sku.ProductSkuDO;
import top.metass.pro.module.product.service.sku.ProductSkuService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * TODO LeeYan9: 类注释;
 * @author LeeYan9
 * @since 2022-09-06
 */
@Service
@Validated
public class ProductSkuApiImpl implements ProductSkuApi {

    @Resource
    private ProductSkuService productSkuService;

    @Override
    public ProductSkuRespDTO getSku(Long id) {
        // TODO TODO LeeYan9: 需要实现
        return null;
    }

    @Override
    public List<ProductSkuRespDTO> getSkuList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        List<ProductSkuDO> skus = productSkuService.getSkuList(ids);
        return ProductSkuConvert.INSTANCE.convertList04(skus);
    }

    @Override
    public void updateSkuStock(ProductSkuUpdateStockReqDTO updateStockReqDTO) {
        productSkuService.updateSkuStock(updateStockReqDTO);
    }

}
