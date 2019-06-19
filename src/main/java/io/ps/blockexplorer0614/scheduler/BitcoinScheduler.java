package io.ps.blockexplorer0614.scheduler;

import io.ps.blockexplorer0614.service.BlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BitcoinScheduler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BlockService blockService;
    @Scheduled(fixedRate = 3000)
    @Async
    public void syncData(){

        //logger.info("begin to sync bitcoin data");
    }
}
