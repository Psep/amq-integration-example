package cl.psep.api.amq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private AMQProducer amqProducer;

    @PostMapping("/messages")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        try {
            amqProducer.sendMessage(message.getBody());
            return ResponseEntity.ok("Message sent to AMQ queue");
        } catch (Exception e) {
            logger.error("error", e);
            return ResponseEntity.internalServerError().body("Error " + e.getMessage());
        }
        
    }
    
}
