package top.metass.pro.module.pay.convert.demo;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.pay.controller.admin.demo.vo.PayDemoOrderCreateReqVO;
import top.metass.pro.module.pay.controller.admin.demo.vo.PayDemoOrderRespVO;
import top.metass.pro.module.pay.dal.dataobject.demo.PayDemoOrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 示例订单 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface PayDemoOrderConvert {

    PayDemoOrderConvert INSTANCE = Mappers.getMapper(PayDemoOrderConvert.class);

    PayDemoOrderDO convert(PayDemoOrderCreateReqVO bean);

    PayDemoOrderRespVO convert(PayDemoOrderDO bean);

    PageResult<PayDemoOrderRespVO> convertPage(PageResult<PayDemoOrderDO> page);

}
