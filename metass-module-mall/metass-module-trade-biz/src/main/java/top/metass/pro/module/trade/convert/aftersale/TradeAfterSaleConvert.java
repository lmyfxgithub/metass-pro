package top.metass.pro.module.trade.convert.aftersale;

import cn.hutool.core.collection.CollUtil;
import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.member.api.user.dto.MemberUserRespDTO;
import top.metass.pro.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import top.metass.pro.module.product.api.property.dto.ProductPropertyValueDetailRespDTO;
import top.metass.pro.module.trade.controller.admin.aftersale.vo.TradeAfterSaleRespPageItemVO;
import top.metass.pro.module.trade.controller.admin.base.member.user.MemberUserRespVO;
import top.metass.pro.module.trade.controller.admin.base.product.property.ProductPropertyValueDetailRespVO;
import top.metass.pro.module.trade.controller.app.aftersale.vo.AppTradeAfterSaleCreateReqVO;
import top.metass.pro.module.trade.dal.dataobject.aftersale.TradeAfterSaleDO;
import top.metass.pro.module.trade.dal.dataobject.order.TradeOrderItemDO;
import top.metass.pro.module.trade.framework.order.config.TradeOrderProperties;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.*;
import java.util.stream.Collectors;

import static top.metass.pro.framework.common.util.collection.CollectionUtils.convertMap;

@Mapper
public interface TradeAfterSaleConvert {

    TradeAfterSaleConvert INSTANCE = Mappers.getMapper(TradeAfterSaleConvert.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createTime", ignore = true),
            @Mapping(target = "updateTime", ignore = true),
            @Mapping(target = "creator", ignore = true),
            @Mapping(target = "updater", ignore = true),
    })
    TradeAfterSaleDO convert(AppTradeAfterSaleCreateReqVO createReqVO, TradeOrderItemDO tradeOrderItem);

    @Mappings({
            @Mapping(source = "afterSale.applyReason", target = "reason"),
            @Mapping(source = "afterSale.refundPrice", target = "amount")
    })
    PayRefundCreateReqDTO convert(String userIp, TradeAfterSaleDO afterSale,
                                  TradeOrderProperties orderProperties);

    MemberUserRespVO convert(MemberUserRespDTO bean);

    PageResult<TradeAfterSaleRespPageItemVO> convertPage(PageResult<TradeAfterSaleDO> page);

    default PageResult<TradeAfterSaleRespPageItemVO> convertPage(PageResult<TradeAfterSaleDO> pageResult,
                                                                 Map<Long, MemberUserRespDTO> memberUsers, List<ProductPropertyValueDetailRespDTO> propertyValueDetails) {
        PageResult<TradeAfterSaleRespPageItemVO> pageVOResult = convertPage(pageResult);
        // 处理会员 + 商品属性等关联信息
        Map<Long, ProductPropertyValueDetailRespDTO> propertyValueDetailMap = convertMap(propertyValueDetails, ProductPropertyValueDetailRespDTO::getValueId);
        for (int i = 0; i < pageResult.getList().size(); i++) {
            TradeAfterSaleRespPageItemVO afterSaleVO = pageVOResult.getList().get(i);
            TradeAfterSaleDO afterSaleDO = pageResult.getList().get(i);
            // 会员
            afterSaleVO.setUser(convert(memberUsers.get(afterSaleDO.getUserId())));
            // 商品属性
            if (CollUtil.isNotEmpty(afterSaleDO.getProperties())) {
                afterSaleVO.setProperties(new ArrayList<>(afterSaleDO.getProperties().size()));
                // 遍历每个 properties，设置到 TradeOrderPageItemRespVO.Item 中
                afterSaleDO.getProperties().forEach(property -> {
                    ProductPropertyValueDetailRespDTO propertyValueDetail = propertyValueDetailMap.get(property.getValueId());
                    if (propertyValueDetail == null) {
                        return;
                    }
                    afterSaleVO.getProperties().add(convert(propertyValueDetail));
                });
            }
        }
        return pageVOResult;
    }

    ProductPropertyValueDetailRespVO convert(ProductPropertyValueDetailRespDTO bean);

    default Set<Long> convertPropertyValueIds(List<TradeAfterSaleDO> list) {
        if (CollUtil.isEmpty(list)) {
            return new HashSet<>();
        }
        return list.stream().filter(item -> item.getProperties() != null)
                .flatMap(p -> p.getProperties().stream()) // 遍历多个 Property 属性
                .map(TradeOrderItemDO.Property::getValueId) // 将每个 Property 转换成对应的 propertyId，最后形成集合
                .collect(Collectors.toSet());
    }

}
