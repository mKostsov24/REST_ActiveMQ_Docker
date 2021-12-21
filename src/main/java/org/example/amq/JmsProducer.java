package org.example.amq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.InputDataDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class JmsProducer {

    private final JmsTemplate jmsTemplate;

    @Value("queue-1")
    String destinationOne;
    @Value("queue-2")
    String destinationTwo;

    public void send(List<InputDataDTO> message) {
        message.forEach(m -> {
                    Map<String, String> map = new HashMap<>();
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
