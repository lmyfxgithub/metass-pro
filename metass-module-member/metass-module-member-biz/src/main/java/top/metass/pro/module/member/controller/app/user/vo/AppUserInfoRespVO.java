package top.metass.pro.module.member.controller.app.user.vo;

import top.metass.pro.framework.desensitize.core.slider.annotation.MobileDesensitize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "用户 APP - 用户个人信息 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserInfoRespVO {

    @Schema(description = "用户昵称", required = true, example = "三生")
    private String nickname;

    @Schema(description = "用户头像", required = true, example = "/infra/file/get/35a12e57-4297-4faa-bf7d-7ed2f211c952")
    private String avatar;

    @Schema(description = "用户手机号", required = true, example = "15601691300")
    @MobileDesensitize // 手机号的脱敏注解
    private String mobile;
}
