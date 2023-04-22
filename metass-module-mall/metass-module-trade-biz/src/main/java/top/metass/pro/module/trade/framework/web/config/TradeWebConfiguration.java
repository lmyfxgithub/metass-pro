package top.metass.pro.module.trade.framework.web.config;

import top.metass.pro.framework.swagger.config.MetassSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * trade 模块的 web 组件的 Configuration
 *
 * @author 三生宇宙
 */
@Configuration(proxyBeanMethods = false)
public class TradeWebConfiguration {

    /**
     * trade 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi tradeGroupedOpenApi() {
        return MetassSwaggerAutoConfiguration.buildGroupedOpenApi("trade");
    }

}
