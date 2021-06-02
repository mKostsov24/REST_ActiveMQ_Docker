package org.example.amq;


import org.example.dto.InputDataDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class JmsProducer {

    private final JmsTemplate jmsTemplate;
    Logger log = LoggerFactory.getLogger(JmsProducer.class);
    @Value("queue-1")
    String destinationOne;
    @Value("queue-2")
    String destinationTwo;

    @Autowired
    public JmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(List<InputDataDTO> message) {

        message.forEach(m -> {
                    HashMap map = new HashMap();
                    map.put("queueName", m.getQueueName());
                    map.put("bodyMessage", m.getBodyMessage());
                    map.put("id", m.getId());
                    if (m.getQueueName().equals(destinationOne)) {

                        jmsTemplate.convertAndSend(destinationOne, map);
                    } else {
                        jmsTemplate.convertAndSend(destinationTwo, map);
                    }
                    log.info("Sent message='{}'", map);
                }
        );
    }
}
