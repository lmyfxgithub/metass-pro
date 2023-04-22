package top.metass.pro.module.member.controller.app.spu.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "用户 APP - 查询商品列表 Request VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppSpuReqVO {

    private Long id;


}
