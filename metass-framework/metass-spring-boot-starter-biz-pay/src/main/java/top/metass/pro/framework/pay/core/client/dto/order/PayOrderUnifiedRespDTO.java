package top.metass.pro.framework.pay.core.client.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 统一下单 Response DTO
 *
 * @author 三生宇宙
 */
@Data
public class PayOrderUnifiedRespDTO {

    /**
     * 展示模式
     */
    private String displayMode;
    /**
     * 展示内容
     */
    private String displayContent;

}
