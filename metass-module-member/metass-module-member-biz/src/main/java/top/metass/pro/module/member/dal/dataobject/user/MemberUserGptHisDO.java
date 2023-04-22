package top.metass.pro.module.member.dal.dataobject.user;

import top.metass.pro.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import top.metass.pro.framework.mybatis.core.dataobject.BaseDO;

/**
 * 会员gpt扩展历史 DO
 *
 * @author 三生
 */
@TableName("member_user_gpt_his")
@KeySequence("member_user_gpt_his_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberUserGptHisDO extends TenantBaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 动作 add/del
     */
    private String active;
    /**
     * 数量
     */
    private Integer conut;
    /**
     * 备用字段1
     */
    private String parm1;
    /**
     * 备用字段2
     */
    private String parm2;
    /**
     * 备注
     */
    private String remark;
    /**
     * 乐观锁
     */
    private Integer revision;

}
