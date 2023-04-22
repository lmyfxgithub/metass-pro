package top.metass.pro.module.promotion.enums.common;

import top.metass.pro.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 营销的商品范围枚举
 *
 * @author 三生宇宙
 */
@Getter
@AllArgsConstructor
public enum PromotionProductScopeEnum implements IntArrayValuable {

    ALL(1, "全部商品参与"),
    SPU(2, "指定商品参与"),
    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(PromotionProductScopeEnum::getScope).toArray();

    /**
     * 范围值
     */
    private final Integer scope;
    /**
     * 范围名
     */
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }

}
