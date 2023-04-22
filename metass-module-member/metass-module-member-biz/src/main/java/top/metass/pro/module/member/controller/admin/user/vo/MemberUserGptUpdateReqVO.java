package top.metass.pro.module.member.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 会员gpt扩展更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberUserGptUpdateReqVO extends MemberUserGptBaseVO {

    @Schema(description = "id主键", required = true, example = "1140")
    @NotNull(message = "id主键不能为空")
    private Long id;

}
