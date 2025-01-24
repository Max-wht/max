package com.max.pubisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class PubisherApplicationTests {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void sendObjects(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","max");
        map.put("age",18);
        rabbitTemplate.convertAndSend("max.object.queue",map);
    }


}
