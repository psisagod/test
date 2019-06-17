package io.ps.blockexplorer0614;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("io.ps.block_explorer0614.dao")
@EnableFeignClients
public class BlockExplorer0614Application {

    public static void main(String[] args) {
        SpringApplication.run(BlockExplorer0614Application.class, args);
    }

}
