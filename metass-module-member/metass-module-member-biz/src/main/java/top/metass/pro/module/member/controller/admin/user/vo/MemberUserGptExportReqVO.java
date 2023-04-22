package top.metass.pro.module.member.controller.admin.user.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import top.metass.pro.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

import static top.metass.pro.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 会员gpt扩展 Excel 导出 Request VO，参数和 MemberUserGptPageReqVO 是一致的")
@Data
public class MemberUserGptExportReqVO {

    @Schema(description = "用户id", example = "7653")
    private Long userId;

    @Schema(description = "用户手机号")
    private String mobile;

    @Schema(description = "会员类型", example = "2")
    private String vipType;

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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "更新时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] updateTime;

}
