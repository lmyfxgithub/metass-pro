package top.metass.pro.framework.file.config;

import top.metass.pro.framework.file.core.client.FileClientFactory;
import top.metass.pro.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 文件配置类
 *
 * @author 三生宇宙
 */
@AutoConfiguration
public class MetassFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
