package top.metass.pro.module.product.convert.category;

import top.metass.pro.module.product.controller.admin.category.vo.ProductCategoryCreateReqVO;
import top.metass.pro.module.product.controller.admin.category.vo.ProductCategoryRespVO;
import top.metass.pro.module.product.controller.admin.category.vo.ProductCategoryUpdateReqVO;
import top.metass.pro.module.product.controller.app.category.vo.AppCategoryRespVO;
import top.metass.pro.module.product.dal.dataobject.category.ProductCategoryDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 商品分类 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface ProductCategoryConvert {

    ProductCategoryConvert INSTANCE = Mappers.getMapper(ProductCategoryConvert.class);

    ProductCategoryDO convert(ProductCategoryCreateReqVO bean);

    ProductCategoryDO convert(ProductCategoryUpdateReqVO bean);

    ProductCategoryRespVO convert(ProductCategoryDO bean);

    List<ProductCategoryRespVO> convertList(List<ProductCategoryDO> list);

    List<AppCategoryRespVO> convertList03(List<ProductCategoryDO> list);
}
