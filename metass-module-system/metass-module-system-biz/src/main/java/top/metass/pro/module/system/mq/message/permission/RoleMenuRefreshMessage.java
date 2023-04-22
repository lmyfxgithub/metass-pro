package top.metass.pro.module.system.mq.message.permission;

import top.metass.pro.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色与菜单数据刷新 Message
 *
 * @author 三生宇宙
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleMenuRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "system.role-menu.refresh";
    }

}
