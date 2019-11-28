package cn.liuyiyou.springboot.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: liuyiyou.cn
 * @date: 2019/11/28
 * @version: V1.0
 */
@Component
@Slf4j
public class CustomerKafkaListener {

    @KafkaListener(topics = "LYY_Test")
    public void processMessage(String content) {
        log.info("消费消息::{}", content);

    }
}
