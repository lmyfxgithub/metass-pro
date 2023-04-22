package top.metass.pro.module.infra.framework.web.config;

import top.metass.pro.framework.swagger.config.MetassSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * infra 模块的 web 组件的 Configuration
 *
 * @author 三生宇宙
 */
@Configuration(proxyBeanMethods = false)
public class InfraWebConfiguration {

    /**
     * infra 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi infraGroupedOpenApi() {
        return MetassSwaggerAutoConfiguration.buildGroupedOpenApi("infra");
    }

}
