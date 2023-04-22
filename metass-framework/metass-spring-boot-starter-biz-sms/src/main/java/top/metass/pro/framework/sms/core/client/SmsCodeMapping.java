package top.metass.pro.framework.sms.core.client;

import top.metass.pro.framework.common.exception.ErrorCode;
import top.metass.pro.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.function.Function;

/**
 * 将 API 的错误码，转换为通用的错误码
 *
 * @see SmsCommonResult
 * @see SmsFrameworkErrorCodeConstants
 *
 * @author 三生宇宙
 */
public interface SmsCodeMapping extends Function<String, ErrorCode> {
}
