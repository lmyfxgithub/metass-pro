package top.metass.pro.module.pay.enums.refund;

import top.metass.pro.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付订单的退款状态枚举
 *
 * @author 三生宇宙
 */
@Getter
@AllArgsConstructor
public enum PayRefundTypeEnum implements IntArrayValuable {

    NO(0, "未退款"),
    SOME(10, "部分退款"),
    ALL(20, "全部退款")
    ;

    private final Integer status;
    private final String name;

    @Override
    public int[] array() {
        return new int[0];
    }

}
