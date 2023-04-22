package top.metass.pro.module.product.convert.brand;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.product.controller.admin.brand.vo.ProductBrandCreateReqVO;
import top.metass.pro.module.product.controller.admin.brand.vo.ProductBrandRespVO;
import top.metass.pro.module.product.controller.admin.brand.vo.ProductBrandUpdateReqVO;
import top.metass.pro.module.product.dal.dataobject.brand.ProductBrandDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 品牌 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface ProductBrandConvert {

    ProductBrandConvert INSTANCE = Mappers.getMapper(ProductBrandConvert.class);

    ProductBrandDO convert(ProductBrandCreateReqVO bean);

    ProductBrandDO convert(ProductBrandUpdateReqVO bean);

    ProductBrandRespVO convert(ProductBrandDO bean);

    List<ProductBrandRespVO> convertList(List<ProductBrandDO> list);

    PageResult<ProductBrandRespVO> convertPage(PageResult<ProductBrandDO> page);

}
