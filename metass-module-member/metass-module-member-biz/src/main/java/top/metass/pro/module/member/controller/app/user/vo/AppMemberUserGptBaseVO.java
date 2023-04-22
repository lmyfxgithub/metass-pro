package top.metass.pro.module.member.controller.app.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static top.metass.pro.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 会员gpt扩展 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AppMemberUserGptBaseVO {

    @Schema(description = "用户id", required = true, example = "7653")
    @NotNull(message = "用户id不能为空")
    private String userId;

    @Schema(description = "用户手机号", required = true)
    @NotNull(message = "用户手机号不能为空")
    private String mobile;

    @Schema(description = "会员类型", required = true, example = "2")
    @NotNull(message = "会员类型不能为空")
    private String vipType;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "会员过期时间")
    private LocalDateTime vipExpires;

    @Schema(description = "会员积分-1积分对话一次")
    private String integral;

    @Schema(description = "预留字段1")
    private String parm1;

    @Schema(description = "预留2")
    private String parm2;

    @Schema(description = "预留json")
    private String parmJson;

    @Schema(description = "乐观锁")
    private Integer revision;

    @Schema(description = "更新时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime updateTime;

}
