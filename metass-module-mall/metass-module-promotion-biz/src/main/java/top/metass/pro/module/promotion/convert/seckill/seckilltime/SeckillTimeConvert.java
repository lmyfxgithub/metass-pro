package top.metass.pro.module.promotion.convert.seckill.seckilltime;

import java.util.*;

import top.metass.pro.framework.common.pojo.PageResult;

import top.metass.pro.module.promotion.controller.admin.seckill.vo.time.SeckillTimeCreateReqVO;
import top.metass.pro.module.promotion.controller.admin.seckill.vo.time.SeckillTimeRespVO;
import top.metass.pro.module.promotion.controller.admin.seckill.vo.time.SeckillTimeUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.metass.pro.module.promotion.dal.dataobject.seckill.seckilltime.SeckillTimeDO;

/**
 * 秒杀时段 Convert
 *
 * @author 三生宇宙
 */
@Mapper
public interface SeckillTimeConvert {

    SeckillTimeConvert INSTANCE = Mappers.getMapper(SeckillTimeConvert.class);

    SeckillTimeDO convert(SeckillTimeCreateReqVO bean);

    SeckillTimeDO convert(SeckillTimeUpdateReqVO bean);

    SeckillTimeRespVO convert(SeckillTimeDO bean);

    List<SeckillTimeRespVO> convertList(List<SeckillTimeDO> list);

    PageResult<SeckillTimeRespVO> convertPage(PageResult<SeckillTimeDO> page);

}
