package top.metass.pro.module.member.dal.dataobject.user;

import top.metass.pro.framework.tenant.core.db.TenantBaseDO;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import top.metass.pro.framework.mybatis.core.dataobject.BaseDO;

import javax.validation.constraints.NotNull;

/**
 * 会员gpt扩展 DO
 *
 * @author 三生
 */
@TableName("member_user_gpt")
@KeySequence("member_user_gpt_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberUserGptDO extends TenantBaseDO {

    /**
     * id主键
     */
    @TableId
    private Long id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户手机号
     */
    private String mobile;
    /**
     * 会员类型
     */
    private String vipType;
    /**
     * 会员过期时间
     */
    private LocalDateTime vipExpires;

    /**
     * 会员积分-1积分对话一次
     */
    private String integral;
    /**
     * 预留字段1
     */
    private String parm1;
    /**
     * 预留2
     */
    private String parm2;
    /**
     * 预留json
     */
    private String parmJson;
    /**
     * 乐观锁
     */
    private Integer revision;


}
