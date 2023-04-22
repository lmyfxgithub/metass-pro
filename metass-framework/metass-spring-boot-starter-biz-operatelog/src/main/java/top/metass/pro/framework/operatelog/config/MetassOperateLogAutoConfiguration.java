package top.metass.pro.framework.operatelog.config;

import top.metass.pro.framework.operatelog.core.aop.OperateLogAspect;
import top.metass.pro.framework.operatelog.core.service.OperateLogFrameworkService;
import top.metass.pro.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import top.metass.pro.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class MetassOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
