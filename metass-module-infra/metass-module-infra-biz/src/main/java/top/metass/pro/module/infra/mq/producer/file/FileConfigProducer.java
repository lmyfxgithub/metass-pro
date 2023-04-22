package top.metass.pro.module.infra.mq.producer.file;

import top.metass.pro.framework.mq.core.RedisMQTemplate;
import top.metass.pro.module.infra.mq.message.file.FileConfigRefreshMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 文件配置相关消息的 Producer
 */
@Component
public class FileConfigProducer {

    @Resource
    private RedisMQTemplate redisMQTemplate;

    /**
     * 发送 {@link FileConfigRefreshMessage} 消息
     */
    public void sendFileConfigRefreshMessage() {
        FileConfigRefreshMessage message = new FileConfigRefreshMessage();
        redisMQTemplate.send(message);
    }

}
