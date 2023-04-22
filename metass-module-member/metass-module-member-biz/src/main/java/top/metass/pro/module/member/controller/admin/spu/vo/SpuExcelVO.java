package top.metass.pro.module.member.controller.admin.spu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import top.metass.pro.framework.excel.core.annotations.DictFormat;
import top.metass.pro.framework.excel.core.convert.DictConvert;


/**
 * 会员商品 Excel VO
 *
 * @author 三生
 */
@Data
public class SpuExcelVO {

    @ExcelProperty("商品id")
    private Long id;

    @ExcelProperty("商品名称")
    private String name;

    @ExcelProperty("商品价格")
    private Integer price;

    @ExcelProperty("商品类型")
    private String type;

    @ExcelProperty("商品描述json")
    private String info;

    @ExcelProperty(value = "商品状态", converter = DictConvert.class)
    @DictFormat("product_spu_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte status;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("创建人")
    private String creator;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;

}
