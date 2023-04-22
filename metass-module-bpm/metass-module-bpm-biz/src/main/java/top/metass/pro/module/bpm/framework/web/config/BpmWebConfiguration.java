package top.metass.pro.module.bpm.framework.web.config;

import top.metass.pro.framework.swagger.config.MetassSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bpm 模块的 web 组件的 Configuration
 *
 * @author 三生宇宙
 */
@Configuration(proxyBeanMethods = false)
public class BpmWebConfiguration {

    /**
     * bpm 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi bpmGroupedOpenApi() {
        return MetassSwaggerAutoConfiguration.buildGroupedOpenApi("bpm");
    }

}
