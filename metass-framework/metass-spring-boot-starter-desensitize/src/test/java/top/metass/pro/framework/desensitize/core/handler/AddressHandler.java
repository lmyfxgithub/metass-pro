package top.metass.pro.framework.desensitize.core.handler;

import top.metass.pro.framework.desensitize.core.DesensitizeTest;
import top.metass.pro.framework.desensitize.core.base.handler.DesensitizationHandler;
import top.metass.pro.framework.desensitize.core.annotation.Address;

/**
 * {@link Address} 的脱敏处理器
 *
 * 用于 {@link DesensitizeTest} 测试使用
 */
public class AddressHandler implements DesensitizationHandler<Address> {

    @Override
    public String desensitize(String origin, Address annotation) {
        return origin + annotation.replacer();
    }

}
