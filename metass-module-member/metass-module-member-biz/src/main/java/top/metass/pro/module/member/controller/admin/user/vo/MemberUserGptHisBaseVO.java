package top.metass.pro.module.member.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static top.metass.pro.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 会员gpt扩展历史 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MemberUserGptHisBaseVO {

    @Schema(description = "用户编号", required = true, example = "15513")
    @NotNull(message = "用户编号不能为空")
    private Long userId;

    @Schema(description = "动作 add/del", required = true)
    @NotNull(message = "动作 add/del不能为空")
    private String active;

    @Schema(description = "数量", required = true)
    @NotNull(message = "数量不能为空")
    private Integer conut;

    @Schema(description = "备用字段1")
    private String parm1;

    @Schema(description = "备用字段2")
    private String parm2;

    @Schema(description = "备注", example = "你说的对")
    private String remark;

    @Schema(description = "乐观锁")
    private Integer revision;

    @Schema(description = "更新时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime updateTime;

}
