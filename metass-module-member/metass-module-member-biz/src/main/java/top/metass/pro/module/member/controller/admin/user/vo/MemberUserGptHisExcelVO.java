package top.metass.pro.module.member.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 会员gpt扩展历史 Excel VO
 *
 * @author 三生
 */
@Data
public class MemberUserGptHisExcelVO {

    @ExcelProperty("主键")
    private Long id;

    @ExcelProperty("用户编号")
    private Long userId;

    @ExcelProperty("动作 add/del")
    private String active;

    @ExcelProperty("数量")
    private Integer conut;

    @ExcelProperty("备用字段1")
    private String parm1;

    @ExcelProperty("备用字段2")
    private String parm2;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("乐观锁")
    private Integer revision;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;

}
