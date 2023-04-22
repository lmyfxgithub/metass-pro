package top.metass.pro.framework.idempotent.config;

import top.metass.pro.framework.idempotent.core.aop.IdempotentAspect;
import top.metass.pro.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import top.metass.pro.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import top.metass.pro.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import top.metass.pro.framework.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import top.metass.pro.framework.redis.config.MetassRedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = MetassRedisAutoConfiguration.class)
public class MetassIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
