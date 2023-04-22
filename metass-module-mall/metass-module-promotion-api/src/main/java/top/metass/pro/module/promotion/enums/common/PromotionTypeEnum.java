package top.metass.pro.module.promotion.enums.common;

import top.metass.pro.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 营销类型枚举
 *
 * @author 三生宇宙
 */
@Getter
@AllArgsConstructor
public enum PromotionTypeEnum implements IntArrayValuable {

    DISCOUNT_ACTIVITY(1, "限时折扣"),
    REWARD_ACTIVITY(2, "满减送"),

    MEMBER(3, "会员折扣"),
    COUPON(4, "优惠劵")
    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(PromotionTypeEnum::getType).toArray();

    /**
     * 类型值
     */
    private final Integer type;
    /**
     * 类型名
     */
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }
}
