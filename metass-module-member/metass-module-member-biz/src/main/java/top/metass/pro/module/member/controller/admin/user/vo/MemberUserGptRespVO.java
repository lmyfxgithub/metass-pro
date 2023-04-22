package top.metass.pro.module.member.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 会员gpt扩展 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberUserGptRespVO extends MemberUserGptBaseVO {

    @Schema(description = "id主键", required = true, example = "1140")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
