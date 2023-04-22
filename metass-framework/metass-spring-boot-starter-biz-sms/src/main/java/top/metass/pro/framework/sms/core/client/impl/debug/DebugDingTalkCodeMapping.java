package top.metass.pro.framework.sms.core.client.impl.debug;

import top.metass.pro.framework.common.exception.ErrorCode;
import top.metass.pro.framework.common.exception.enums.GlobalErrorCodeConstants;
import top.metass.pro.framework.sms.core.client.SmsCodeMapping;
import top.metass.pro.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.Objects;

/**
 * 钉钉的 SmsCodeMapping 实现类
 *
 * @author 三生宇宙
 */
public class DebugDingTalkCodeMapping implements SmsCodeMapping {

    @Override
    public ErrorCode apply(String apiCode) {
        return Objects.equals(apiCode, "0") ? GlobalErrorCodeConstants.SUCCESS : SmsFrameworkErrorCodeConstants.SMS_UNKNOWN;
    }

}
