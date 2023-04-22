package top.metass.pro.framework.sms.config;

import top.metass.pro.framework.sms.core.client.SmsClientFactory;
import top.metass.pro.framework.sms.core.client.impl.SmsClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 短信配置类
 *
 * @author 三生宇宙
 */
@AutoConfiguration
public class MetassSmsAutoConfiguration {

    @Bean
    public SmsClientFactory smsClientFactory() {
        return new SmsClientFactoryImpl();
    }

}
