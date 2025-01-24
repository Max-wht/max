package com.max.pubisher;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PubisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(PubisherApplication.class, args);
    }
    @Bean
    public MessageConverter jasksonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
