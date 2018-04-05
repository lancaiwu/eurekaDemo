package com.example.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 该注解用来指定一个或多个定义了@Input或@Output注解的接口
 * <p>
 * Sink  接受消息的接口
 */
@EnableBinding(InputChannel.class)
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(StreamApplication.class);

    /**
     * @param message
     * @StreamListener 注解使方法接受管道推送的消息。
     */
    @StreamListener(Sink.INPUT)
    public void handle(Object message) {
        logger.info("message received {}", message);
        System.out.println(message);
    }

}
