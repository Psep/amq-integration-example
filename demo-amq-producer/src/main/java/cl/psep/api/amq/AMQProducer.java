package cl.psep.api.amq;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class AMQProducer {


    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(queue, message);
    }
}