package top.metass.pro.module.member.controller.app.spu.vo;

import top.metass.pro.module.member.controller.app.user.vo.AppMemberUserGptBaseVO;
import lombok.*;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "用户 APP - 会员商品 Excel 导出 Request VO，参数和 SpuPageReqVO 是一致的")
@Data
public class AppSpuExportReqVO {

    @Schema(description = "商品名称", example = "张三")
    private String name;

    @Schema(description = "商品类型", example = "2")
    private String type;

    @Schema(description = "商品描述json")
    private String info;

    @Schema(description = "商品状态", example = "1")
    private Byte status;

    @Schema(description = "用户 APP - 会员gpt扩展 Response VO")
    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    public static class AppSpuRespVO extends AppMemberUserGptBaseVO {

        @Schema(description = "id主键", required = true, example = "1140")
        private Long id;

        @Schema(description = "创建时间")
        private LocalDateTime createTime;

    }
}
