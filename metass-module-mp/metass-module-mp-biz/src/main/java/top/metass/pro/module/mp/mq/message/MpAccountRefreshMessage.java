package top.metass.pro.module.mp.mq.message;

import top.metass.pro.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 公众号账号刷新 Message
 *
 * @author 三生宇宙
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MpAccountRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "mp.account.refresh";
    }

}
