package top.metass.pro.module.member.controller.app.spu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "用户 APP - 会员商品更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppSpuUpdateReqVO extends AppSpuBaseVO {

    @Schema(description = "商品id", required = true, example = "28711")
    @NotNull(message = "商品id不能为空")
    private Long id;

    @Schema(description = "备注", example = "你猜")
    private String remark;

}
