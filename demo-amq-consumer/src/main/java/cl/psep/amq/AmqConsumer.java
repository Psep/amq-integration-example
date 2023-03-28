package cl.psep.amq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AmqConsumer {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @JmsListener(destination = "AddressExample::queue.example", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String message) {
        logger.info(String.format("Received message: %s", message));
    }
}

