package top.metass.pro.framework.pay.config;

import top.metass.pro.framework.pay.core.client.PayClientFactory;
import top.metass.pro.framework.pay.core.client.impl.PayClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 支付配置类
 *
 * @author 三生宇宙
 */
@AutoConfiguration
@EnableConfigurationProperties(PayProperties.class)
public class MetassPayAutoConfiguration {

    @Bean
    public PayClientFactory payClientFactory() {
        return new PayClientFactoryImpl();
    }

}
