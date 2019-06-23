package io.ps.blockexplorer0614.scheduler;

import io.ps.blockexplorer0614.service.TxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BitcoinScheduler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TxService txService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedRate = 3000)
    public void syncData() {

        logger.info("begin to sync bitcoin data"+txService.getRecentTxs());
        simpMessagingTemplate.convertAndSend("/mytopic/greetings", txService.getRecentTxs());
    }
}
