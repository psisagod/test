package io.ps.blockexplorer0614.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @MessageMapping("/greeting")
    @SendTo("/mytopic/greetings")
    public String greeting(String message) throws Exception {
        return "hello" + message;
    }

}
