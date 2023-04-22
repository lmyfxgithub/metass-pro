package top.metass.pro.module.member.api.spu.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户信息 Response DTO
 *
 * @author 三生宇宙
 */
@Data
public class MemberSpuRespDTO {

    private Long id;

    private String name;

    private Integer price;

    private String type;

    private String info;

    private Byte status;

    private String remark;

    private String creator;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
