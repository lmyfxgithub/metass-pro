package top.metass.pro.module.member.controller.admin.spu.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import top.metass.pro.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 会员商品分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpuPageReqVO extends PageParam {

    @Schema(description = "商品名称", example = "张三")
    private String name;

    @Schema(description = "商品价格", example = "15492")
    private Integer price;

    @Schema(description = "商品类型", example = "2")
    private String type;

    @Schema(description = "商品描述json")
    private String info;

    @Schema(description = "商品时限天/次数")
    private String parm1;

    @Schema(description = "商品状态", example = "1")
    private Byte status;

    @Schema(description = "备注", example = "你猜")
    private String remark;

}
