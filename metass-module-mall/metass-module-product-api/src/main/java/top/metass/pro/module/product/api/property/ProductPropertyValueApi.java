package top.metass.pro.module.product.api.property;

import top.metass.pro.module.product.api.property.dto.ProductPropertyValueDetailRespDTO;

import java.util.Collection;
import java.util.List;

/**
 * 商品属性值 API 接口
 *
 * @author 三生宇宙
 */
public interface ProductPropertyValueApi {

    /**
     * 根据编号数组，获得属性值列表
     *
     * @param ids 编号数组
     * @return 属性值明细列表
     */
    List<ProductPropertyValueDetailRespDTO> getPropertyValueDetailList(Collection<Long> ids);

}