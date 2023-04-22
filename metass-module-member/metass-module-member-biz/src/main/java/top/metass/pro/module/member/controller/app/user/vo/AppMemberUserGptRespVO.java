package top.metass.pro.module.member.controller.app.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "用户 APP - 会员gpt扩展 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppMemberUserGptRespVO extends AppMemberUserGptBaseVO {

    @Schema(description = "id主键", required = true, example = "1140")
    private Long id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
