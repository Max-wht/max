package com.max;


import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class LisenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LisenerApplication.class, args);

    }
    @Bean
    public MessageConverter jasksonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @PostConstruct
    public void init() {

    }

}
