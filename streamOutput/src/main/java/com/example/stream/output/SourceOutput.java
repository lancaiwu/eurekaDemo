package com.example.stream.output;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
@RestController
@Slf4j
@RequiredArgsConstructor
public class SourceOutput {

    private static Logger logger = LoggerFactory.getLogger(Source.class);

//    @InboundChannelAdapter(value = Source.OUTPUT)
//    public String timerMessage() {
//        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//        logger.info("publish message :" + format);
//        return format;
//    }
//

    private final OutputChannel channel;

    @RequestMapping(method = RequestMethod.GET, value = "/sendMessage/{message}")
    public String sendMessage(@PathVariable String message) {
        logger.info("Receive message {}", message);
        Message<String> msg = org.springframework.messaging.support.MessageBuilder.withPayload(message).build();
        channel.output().send(msg);
        return "Message " + message + " sent to the subscribers";
    }
}
