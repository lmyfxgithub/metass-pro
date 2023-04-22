package top.metass.pro.module.pay.controller.admin.merchant.vo.merchant;

import top.metass.pro.framework.excel.core.annotations.DictFormat;
import top.metass.pro.framework.excel.core.convert.DictConvert;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 支付商户信息 Excel VO
 *
 * @author 三生
 */
@Data
public class PayMerchantExcelVO {

    @ExcelProperty("商户编号")
    private Long id;

    @ExcelProperty("商户号")
    private String no;

    @ExcelProperty("商户全称")
    private String name;

    @ExcelProperty("商户简称")
    private String shortName;

    @ExcelProperty(value = "开启状态",converter = DictConvert.class)
    @DictFormat("sys_common_status")
    private Integer status;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
