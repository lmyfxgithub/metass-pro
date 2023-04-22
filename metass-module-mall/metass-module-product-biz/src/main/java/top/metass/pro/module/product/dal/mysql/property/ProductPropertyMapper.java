package top.metass.pro.module.product.dal.mysql.property;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.mybatis.core.mapper.BaseMapperX;
import top.metass.pro.framework.mybatis.core.query.LambdaQueryWrapperX;
import top.metass.pro.module.product.controller.admin.property.vo.property.ProductPropertyListReqVO;
import top.metass.pro.module.product.controller.admin.property.vo.property.ProductPropertyPageReqVO;
import top.metass.pro.module.product.dal.dataobject.property.ProductPropertyDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductPropertyMapper extends BaseMapperX<ProductPropertyDO> {

    default PageResult<ProductPropertyDO> selectPage(ProductPropertyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductPropertyDO>()
                .likeIfPresent(ProductPropertyDO::getName, reqVO.getName())
                .betweenIfPresent(ProductPropertyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductPropertyDO::getId));
    }

    default ProductPropertyDO selectByName(String name) {
        return selectOne(ProductPropertyDO::getName, name);
    }

    default List<ProductPropertyDO> selectList(ProductPropertyListReqVO listReqVO) {
        return selectList(new LambdaQueryWrapperX<ProductPropertyDO>()
                .eqIfPresent(ProductPropertyDO::getName, listReqVO.getName()));
    }

}
