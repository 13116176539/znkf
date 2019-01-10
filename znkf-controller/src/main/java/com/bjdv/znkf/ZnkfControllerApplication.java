package com.bjdv.znkf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 〈〉
 *
 * @author hanxulei
 * @create 2018/10/11
 * @since 1.0.0
 */
@SpringBootApplication
@ImportResource("classpath:config/spring-*.xml")
public class ZnkfControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run( ZnkfControllerApplication.class, args );
    }
}
