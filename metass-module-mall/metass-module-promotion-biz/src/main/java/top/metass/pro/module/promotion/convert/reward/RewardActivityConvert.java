package top.metass.pro.module.promotion.convert.reward;

import top.metass.pro.framework.common.pojo.PageResult;
import top.metass.pro.module.promotion.controller.admin.reward.vo.RewardActivityCreateReqVO;
import top.metass.pro.module.promotion.controller.admin.reward.vo.RewardActivityRespVO;
import top.metass.pro.module.promotion.controller.admin.reward.vo.RewardActivityUpdateReqVO;
import top.metass.pro.module.promotion.dal.dataobject.reward.RewardActivityDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 满减送活动 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface RewardActivityConvert {

    RewardActivityConvert INSTANCE = Mappers.getMapper(RewardActivityConvert.class);

    RewardActivityDO convert(RewardActivityCreateReqVO bean);

    RewardActivityDO convert(RewardActivityUpdateReqVO bean);

    RewardActivityRespVO convert(RewardActivityDO bean);

    PageResult<RewardActivityRespVO> convertPage(PageResult<RewardActivityDO> page);

}
