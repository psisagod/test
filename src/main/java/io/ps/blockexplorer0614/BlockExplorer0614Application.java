package io.ps.blockexplorer0614;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("io.ps.blockexplorer0614.dao")
@EnableFeignClients
@EnableScheduling
public class BlockExplorer0614Application {

    public static void main(String[] args) {
        SpringApplication.run(BlockExplorer0614Application.class, args);
    }

}
