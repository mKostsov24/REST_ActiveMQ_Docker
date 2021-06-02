package org.example.amq;

import org.example.model.Data;
import org.example.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class JmsConsumer {

    private final DataRepository repository;

    Logger log = LoggerFactory.getLogger(JmsConsumer.class);

    @Autowired
    public JmsConsumer(DataRepository repository) {
        this.repository = repository;
    }

    @Async
    @JmsListener(destination = "queue-1")
    public void receiveOne(HashMap<String, String> realMap) {
        String queue = "queue-1";
        log.info("queue - {} work", queue);
        receive(realMap, queue);
    }

    @Async
    @JmsListener(destination = "queue-2")
    public void receiveTwo(HashMap<String, String> realMap) {
        String queue = "queue-2";
        log.info("queue - {} work", queue);
        receive(realMap, queue);
    }

    public void receive(HashMap<String, String> realMap, String queue){
        Data newMessage = new Data(realMap.get("queueName"), realMap.get("bodyMessage"), Integer.parseInt(realMap.get("id")));
        repository.save(newMessage);
        log.info("Received message='{}' , queue - {}", realMap, queue);
    }

}
