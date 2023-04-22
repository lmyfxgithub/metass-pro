package top.metass.pro.module.member.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 会员gpt扩展历史更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberUserGptHisUpdateReqVO extends MemberUserGptHisBaseVO {

    @Schema(description = "主键", required = true, example = "1600")
    @NotNull(message = "主键不能为空")
    private Long id;

}
