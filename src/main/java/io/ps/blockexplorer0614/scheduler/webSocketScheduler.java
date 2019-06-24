package io.ps.blockexplorer0614.scheduler;

import io.ps.blockexplorer0614.controller.TempController;
import io.ps.blockexplorer0614.service.TxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class webSocketScheduler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TxService txService;
    @Autowired
    private TempController tempController;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

//    @Scheduled(fixedRate = 3000)
//    public void webSocketData() {
//
//        logger.info("begin to webSocketData bitcoin txs data"+txService.getRecentTxs());
//        simpMessagingTemplate.convertAndSend("/mytopic/greetings", txService.getRecentTxs());
//    }
//    @Scheduled(fixedRate = 1000*60)
//    public void syncData() throws Throwable {
//        logger.info("begin to sync bitcoin data");
//        tempController.test();
//    }
}
