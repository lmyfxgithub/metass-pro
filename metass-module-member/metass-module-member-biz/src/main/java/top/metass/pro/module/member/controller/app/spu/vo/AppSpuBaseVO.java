package top.metass.pro.module.member.controller.app.spu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 会员商品 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AppSpuBaseVO {

    @Schema(description = "商品名称", required = true, example = "张三")
    @NotNull(message = "商品名称不能为空")
    private String name;

    @Schema(description = "商品价格", required = true, example = "15492")
    @NotNull(message = "商品价格不能为空")
    private BigDecimal price;

    @Schema(description = "商品类型", required = true, example = "2")
    @NotNull(message = "商品类型不能为空")
    private String type;

    @Schema(description = "商品描述json")
    private String info;

    @Schema(description = "商品状态", required = true, example = "1")
    @NotNull(message = "商品状态不能为空")
    private Byte status;

}
