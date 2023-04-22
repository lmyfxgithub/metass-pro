package top.metass.pro.module.member.controller.app.spu.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import top.metass.pro.framework.common.pojo.PageParam;

@Schema(description = "用户 APP - 会员商品分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppSpuPageReqVO extends PageParam {

    @Schema(description = "商品名称", example = "张三")
    private String name;

    @Schema(description = "商品类型", example = "2")
    private String type;

    @Schema(description = "商品描述json")
    private String info;

    @Schema(description = "商品状态", example = "1")
    private Byte status;

}
