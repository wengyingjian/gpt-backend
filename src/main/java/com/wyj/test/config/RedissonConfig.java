package com.wyj.test.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

//    @Value("${redis.address}")
//    private String address;
//    @Bean
//    public RedissonClient redissonClient() {
//        Config config = new Config();
//        config.setTransportMode(TransportMode.NIO);
//        SingleServerConfig singleServerConfig = config.useSingleServer();
//        singleServerConfig.setAddress("redis://127.0.0.1:6379");
////        singleServerConfig.setPassword("123456");
//        return Redisson.create(config);
//    }
}
