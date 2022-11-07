package be.pxl.boardgame.boardgameapp.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public Sender() { jmsTemplate.setPubSubDomain(true); }
    // pubsub -> public subscribe

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend("hello_queue", "Hello World!");
    }
}

