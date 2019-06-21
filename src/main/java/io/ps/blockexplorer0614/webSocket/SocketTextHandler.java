package io.ps.blockexplorer0614.webSocket;

import io.ps.blockexplorer0614.dto.TxListDTO;
import io.ps.blockexplorer0614.service.TxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;

@Component
public class SocketTextHandler extends TextWebSocketHandler {
    @Autowired
    private TxService txService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<TxListDTO> getRecentTxs(){
        List<TxListDTO> txListDTOS = txService.getRecentTxs();
        return txListDTOS;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {
        //接收消息暂时不需要
        //logger.info("receive message : {}", message.getPayload());
        session.sendMessage(new TextMessage("the count is " + this.getRecentTxs()));
    }
}
