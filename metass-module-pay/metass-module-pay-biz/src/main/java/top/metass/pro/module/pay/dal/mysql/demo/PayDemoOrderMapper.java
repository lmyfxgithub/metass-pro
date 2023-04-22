package top.metass.pro.module.pay.dal.mysql.demo;

import top.metass.pro.framework.common.pojo.PageParam;
import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.framework.mybatis.core.mapper.BaseMapperX;
import top.metass.pro.framework.mybatis.core.query.LambdaQueryWrapperX;
import top.metass.pro.module.pay.dal.dataobject.demo.PayDemoOrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 示例订单 Mapper
 *
 * @author 三生宇宙
 */
@Mapper
public interface PayDemoOrderMapper extends BaseMapperX<PayDemoOrderDO> {

    default PageResult<PayDemoOrderDO> selectPage(PageParam reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PayDemoOrderDO>()
                .orderByDesc(PayDemoOrderDO::getId));
    }

    default int updateByIdAndPayed(Long id, boolean wherePayed, PayDemoOrderDO updateObj) {
        return update(updateObj, new LambdaQueryWrapperX<PayDemoOrderDO>()
                .eq(PayDemoOrderDO::getId, id).eq(PayDemoOrderDO::getPayed, wherePayed));
    }

}
