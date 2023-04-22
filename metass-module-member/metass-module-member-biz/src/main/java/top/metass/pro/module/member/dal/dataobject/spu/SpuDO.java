package top.metass.pro.module.member.dal.dataobject.spu;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import top.metass.pro.framework.mybatis.core.dataobject.BaseDO;

/**
 * 会员商品 DO
 *
 * @author 三生
 */
@TableName("member_spu")
@KeySequence("member_spu_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpuDO extends BaseDO {

    /**
     * 商品id
     */
    @TableId
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 商品类型
     */
    private String type;
    /**
     * 商品描述json
     */
    private String info;
    /**
     * 商品状态
     *
     * 枚举 {@link TODO product_spu_status 对应的类}
     */
    private Byte status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 预留1
     */
    private String parm1;
    /**
     * 预留2
     */
    private String parm2;
    /**
     * 预留3
     */
    private String parm3;
    /**
     * 乐观锁
     */
    private Integer revision;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
