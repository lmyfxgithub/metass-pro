package top.metass.pro.module.product.dal.dataobject.shop;

import top.metass.pro.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

// TODO 三生：待设计
/**
 * 店铺 DO
 *
 * @author 三生宇宙
 */
@TableName("shop")
@KeySequence("shop_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopDO extends BaseDO {

    private Long id;

}
