package top.metass.pro.module.member.controller.admin.spu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 会员商品更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SpuUpdateReqVO extends SpuBaseVO {

    @Schema(description = "商品id", required = true, example = "28711")
    @NotNull(message = "商品id不能为空")
    private Long id;

}
