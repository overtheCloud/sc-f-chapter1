package com.redis.redisdemo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisExpiredListener implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public final static String LISTENER_PATTERN = "__keyevent@0__:expired";

    /**
     * redis 的 key 过期通知事件
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();// 建议使用: valueSerializer
        byte[] channel = message.getChannel();
        logger.info("channel: " + new String(channel) + "; body: " + new String(body) + "; bytes: " + new String(bytes));
    }
}
