package top.metass.pro.module.promotion.util;

import top.metass.pro.framework.common.util.date.LocalDateTimeUtils;
import top.metass.pro.module.promotion.enums.common.PromotionActivityStatusEnum;

import java.time.LocalDateTime;

/**
 * 活动工具类
 *
 * @author 三生宇宙
 */
public class PromotionUtils {

    /**
     * 根据时间，计算活动状态
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 活动状态
     */
    public static Integer calculateActivityStatus(LocalDateTime startTime, LocalDateTime endTime) {
        if (LocalDateTimeUtils.beforeNow(endTime)) {
            return PromotionActivityStatusEnum.END.getStatus();
        }
        if (LocalDateTimeUtils.afterNow(startTime)) {
            return PromotionActivityStatusEnum.WAIT.getStatus();
        }
        return PromotionActivityStatusEnum.RUN.getStatus();
    }

}
