package top.metass.pro.module.member.controller.admin.user.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import top.metass.pro.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static top.metass.pro.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 会员gpt扩展历史 Excel 导出 Request VO，参数和 MemberUserGptHisPageReqVO 是一致的")
@Data
public class MemberUserGptHisExportReqVO {

    @Schema(description = "用户编号", example = "15513")
    private Long userId;

    @Schema(description = "动作 add/del")
    private String active;

    @Schema(description = "数量")
    private Integer conut;

    @Schema(description = "备用字段1")
    private String parm1;

    @Schema(description = "备用字段2")
    private String parm2;

    @Schema(description = "备注", example = "你说的对")
    private String remark;

    @Schema(description = "乐观锁")
    private Integer revision;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "更新时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] updateTime;

}
