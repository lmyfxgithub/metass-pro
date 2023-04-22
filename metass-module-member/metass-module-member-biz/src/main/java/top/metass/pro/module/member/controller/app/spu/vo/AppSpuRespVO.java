package top.metass.pro.module.member.controller.app.spu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "用户 APP - 会员商品 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppSpuRespVO extends AppSpuBaseVO {

    @Schema(description = "商品id", required = true, example = "28711")
    private Long id;

    @Schema(description = "备注", example = "你猜")
    private String remark;

    @Schema(description = "创建人")
    private String creator;

    @Schema(description = "时长/次数")
    private String parm1;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updaterTime;

}
