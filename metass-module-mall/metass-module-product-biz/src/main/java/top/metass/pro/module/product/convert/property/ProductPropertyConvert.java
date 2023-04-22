package top.metass.pro.module.product.convert.property;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.common.util.collection.CollectionUtils;
import top.metass.pro.module.product.controller.admin.property.vo.property.ProductPropertyAndValueRespVO;
import top.metass.pro.module.product.controller.admin.property.vo.property.ProductPropertyCreateReqVO;
import top.metass.pro.module.product.controller.admin.property.vo.property.ProductPropertyRespVO;
import top.metass.pro.module.product.controller.admin.property.vo.property.ProductPropertyUpdateReqVO;
import top.metass.pro.module.product.dal.dataobject.property.ProductPropertyDO;
import top.metass.pro.module.product.dal.dataobject.property.ProductPropertyValueDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

/**
 * 属性项 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface ProductPropertyConvert {

    ProductPropertyConvert INSTANCE = Mappers.getMapper(ProductPropertyConvert.class);

    ProductPropertyDO convert(ProductPropertyCreateReqVO bean);

    ProductPropertyDO convert(ProductPropertyUpdateReqVO bean);

    ProductPropertyRespVO convert(ProductPropertyDO bean);

    List<ProductPropertyRespVO> convertList(List<ProductPropertyDO> list);

    PageResult<ProductPropertyRespVO> convertPage(PageResult<ProductPropertyDO> page);

    default List<ProductPropertyAndValueRespVO> convertList(List<ProductPropertyDO> keys, List<ProductPropertyValueDO> values) {
        Map<Long, List<ProductPropertyValueDO>> valueMap = CollectionUtils.convertMultiMap(values, ProductPropertyValueDO::getPropertyId);
        return CollectionUtils.convertList(keys, key -> {
            ProductPropertyAndValueRespVO respVO = convert02(key);
            respVO.setValues(convertList02(valueMap.get(key.getId())));
            return respVO;
        });
    }
    ProductPropertyAndValueRespVO convert02(ProductPropertyDO bean);
    List<ProductPropertyAndValueRespVO.Value> convertList02(List<ProductPropertyValueDO> list);

}
