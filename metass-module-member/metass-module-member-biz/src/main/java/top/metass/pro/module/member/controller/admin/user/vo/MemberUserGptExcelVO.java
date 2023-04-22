package top.metass.pro.module.member.controller.admin.user.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 会员gpt扩展 Excel VO
 *
 * @author 三生
 */
@Data
public class MemberUserGptExcelVO {

    @ExcelProperty("id主键")
    private Long id;

    @ExcelProperty("用户id")
    private Long userId;

    @ExcelProperty("用户手机号")
    private String mobile;

    @ExcelProperty("会员类型")
    private String vipType;

    @ExcelProperty("会员过期时间")
    private LocalDateTime vipExpires;

    @ExcelProperty("会员积分-1积分对话一次")
    private String integral;

    @ExcelProperty("预留字段1")
    private String parm1;

    @ExcelProperty("预留2")
    private String parm2;

    @ExcelProperty("预留json")
    private String parmJson;

    @ExcelProperty("乐观锁")
    private Integer revision;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;

}
